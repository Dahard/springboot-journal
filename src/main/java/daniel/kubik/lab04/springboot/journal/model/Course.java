package daniel.kubik.lab04.springboot.journal.model;

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

    @OneToMany(mappedBy = "course")
    private List<Student> students;
    private int maxStudentCount;
    private int rate;

}
