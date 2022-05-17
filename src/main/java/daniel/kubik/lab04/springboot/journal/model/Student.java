package daniel.kubik.lab04.springboot.journal.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {

    @Id
    private Long id;
    private String name;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private StudentCondition state;
    private int birthYear;
    private double pointsCount;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Course course;

}