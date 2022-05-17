package daniel.kubik.lab04.springboot.journal.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

@Data
@Entity
public class Course {

    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "group")
    private List<Student> students;
    private int maxStudentCount;

}
