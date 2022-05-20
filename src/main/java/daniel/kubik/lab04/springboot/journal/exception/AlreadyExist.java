package daniel.kubik.lab04.springboot.journal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT)
public class AlreadyExist extends RuntimeException{
    public AlreadyExist(String message) {
        super(message);
    }
}
