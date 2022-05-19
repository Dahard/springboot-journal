package daniel.kubik.lab04.springboot.journal.mappers;

import daniel.kubik.lab04.springboot.journal.dto.CourseData;
import daniel.kubik.lab04.springboot.journal.dto.StudentData;
import daniel.kubik.lab04.springboot.journal.model.Course;
import daniel.kubik.lab04.springboot.journal.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    CourseData map(Course course);
    List<CourseData> map(List<Course> courses);
}
