package daniel.kubik.lab04.springboot.journal.repository;

import daniel.kubik.lab04.springboot.journal.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Course, Long> {


}
