package daniel.kubik.lab04.springboot.journal.repository;

import daniel.kubik.lab04.springboot.journal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByPesel(int pesel);

    void deleteStudentByPesel(int pesel);

    Student findAllByBirthYear(int birthOfYear);

    boolean existsByPesel(int pesel);

}
