package daniel.kubik.lab04.springboot.journal.dto;

import daniel.kubik.lab04.springboot.journal.model.Course;
import daniel.kubik.lab04.springboot.journal.model.StudentCondition;
import lombok.Data;


@Data
public class StudentData {

    private int pesel;
    private String name;
    private String lastName;
    private StudentCondition state;
    private int birthYear;
    private double pointsCount;
    private String courseName;
}
