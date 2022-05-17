package daniel.kubik.lab04.springboot.journal.api;

import daniel.kubik.lab04.springboot.journal.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface JournalApi {

    @PostMapping("/student")
    Student createStudent(Student student);

    @GetMapping("/student/{id}")
    Student getStudent(@PathVariable("id") Long id);

}
