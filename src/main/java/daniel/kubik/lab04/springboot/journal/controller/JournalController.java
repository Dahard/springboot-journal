package daniel.kubik.lab04.springboot.journal.controller;

import daniel.kubik.lab04.springboot.journal.api.JournalApi;
import daniel.kubik.lab04.springboot.journal.dto.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class JournalController implements JournalApi {

    @Override
    public Student createStudent(Student student) {
        return null;
    }

    @Override
    public Student getStudent(Long id) {
        return null;
    }
}
