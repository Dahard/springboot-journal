package daniel.kubik.lab04.springboot.journal.dto;

import daniel.kubik.lab04.springboot.journal.model.Course;
import lombok.Data;

import java.util.List;

@Data
public class RatingData {
    private Long courseId;
    private String courseName;
    private int rate;
}
