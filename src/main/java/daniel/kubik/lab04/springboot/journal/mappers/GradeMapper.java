package daniel.kubik.lab04.springboot.journal.mappers;

import daniel.kubik.lab04.springboot.journal.dto.CourseData;
import daniel.kubik.lab04.springboot.journal.dto.GradeData;
import daniel.kubik.lab04.springboot.journal.model.Course;
import daniel.kubik.lab04.springboot.journal.model.Grade;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {
    GradeData map(Grade grade);
    Grade map(GradeData grade);
    List<GradeData> map(List<Grade> grades);
}
