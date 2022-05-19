package daniel.kubik.lab04.springboot.journal.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {

    @Id()
    private int pesel;
    private String name;
    private String lastName;
    private int birthYear;
    private double pointsCount;

    @Enumerated(EnumType.STRING)
    private StudentCondition state;

    @ManyToOne
    @JoinColumn
    private Course course;

}