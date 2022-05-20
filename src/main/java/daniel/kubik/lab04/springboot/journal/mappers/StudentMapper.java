package daniel.kubik.lab04.springboot.journal.mappers;

import daniel.kubik.lab04.springboot.journal.dto.StudentData;
import daniel.kubik.lab04.springboot.journal.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentData map(Student student);
    List<StudentData> map(List<Student> students);
    Student map(StudentData studentData);
}
