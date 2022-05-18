package daniel.kubik.lab04.springboot.journal.mappers;

import daniel.kubik.lab04.springboot.journal.dto.StudentData;
import daniel.kubik.lab04.springboot.journal.model.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {
    StudentData map(Student student);
}
