package daniel.kubik.lab04.springboot.journal.dto;

import lombok.Data;

@Data
public class GradeData {
    private int studentPesel;
    private double grade;
    private String exerciseTitle;
}
