package daniel.kubik.lab04.springboot.journal.repository;

import daniel.kubik.lab04.springboot.journal.model.Course;
import daniel.kubik.lab04.springboot.journal.model.Grade;
import daniel.kubik.lab04.springboot.journal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findById(Long id);

    Void deleteCourseById(Long id);



}
