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
    private List<StudentListEntry> students;
    List<GradeData> gradeData;

    @Data
    public static class StudentListEntry {
        private String name;
        private String lastName;
        private int pesel;
    }

}
