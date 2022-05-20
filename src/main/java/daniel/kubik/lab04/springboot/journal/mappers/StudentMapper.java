package daniel.kubik.lab04.springboot.journal.mappers;

import daniel.kubik.lab04.springboot.journal.dto.StudentData;
import daniel.kubik.lab04.springboot.journal.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Mapping(target = "courseName", source = "course.name")
    StudentData map(Student student);

    List<StudentData> map(List<Student> students);
    @Mapping(target = "course", ignore = true)
    Student map(StudentData studentData);

    @Mapping(target = "course", ignore = true)
    Student mapWithoutCourse(StudentData studentData);
}
