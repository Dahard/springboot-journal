package daniel.kubik.lab04.springboot.journal.repository;

import daniel.kubik.lab04.springboot.journal.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findAllByStudentPesel(int studentsPesel);
}
