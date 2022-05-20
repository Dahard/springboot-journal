package daniel.kubik.lab04.springboot.journal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Grades not found")
public class GradesNotFound extends RuntimeException{
}
