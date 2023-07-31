package movieBlog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {

    @ExceptionHandler(value = {MovieNotFoundException.class})
    public MovieException handleUserNotFoundException(MovieNotFoundException movieNotFoundException){
        MovieException movieException = new MovieException(
                movieNotFoundException.getMessage(),
                movieNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        {
            return movieException;
        }
    }

}
