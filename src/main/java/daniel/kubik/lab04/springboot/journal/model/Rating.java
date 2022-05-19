package daniel.kubik.lab04.springboot.journal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Rating {
    @Id
    private Long courseId;
    private String courseName;
    private int rate;
}
