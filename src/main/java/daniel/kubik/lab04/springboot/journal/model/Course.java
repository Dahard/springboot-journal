package daniel.kubik.lab04.springboot.journal.model;

import daniel.kubik.lab04.springboot.journal.dto.GradeData;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

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
}
