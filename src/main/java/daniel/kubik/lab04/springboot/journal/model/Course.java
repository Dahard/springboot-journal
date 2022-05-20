package daniel.kubik.lab04.springboot.journal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int maxStudentCount;
    private int rate;

    @OneToMany(mappedBy = "course")
    private List<Student> students;

    @OneToMany(mappedBy = "grade")
    private List<Grade> gradeData;

    public void addStudent(Student student) {
        if (students == null) {
            students = new LinkedList<>();
        }
        students.add(student);
        student.setCourse(this);
    }
}
