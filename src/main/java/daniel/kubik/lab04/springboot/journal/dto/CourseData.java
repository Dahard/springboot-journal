package daniel.kubik.lab04.springboot.journal.dto;

import daniel.kubik.lab04.springboot.journal.model.Student;
import lombok.Data;

import java.util.List;

@Data
public class CourseData {
    private Long id;
    private int maxStudentCount;
    private String name;
    private int rate;
    private List<Student> students;
}
