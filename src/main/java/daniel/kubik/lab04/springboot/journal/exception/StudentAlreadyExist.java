package daniel.kubik.lab04.springboot.journal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="Already created")
public class StudentAlreadyExist extends RuntimeException{

}
