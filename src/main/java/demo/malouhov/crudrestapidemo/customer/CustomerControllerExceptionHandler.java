package demo.malouhov.crudrestapidemo.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomerControllerExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<CustomerErrorResponse> resourceNotFoundException(CustomerNotFoundException exception, WebRequest request) {
        var message = new CustomerErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<CustomerErrorResponse>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomerErrorResponse> globalExceptionHandler(Exception exception, WebRequest request) {
        var message = new CustomerErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<CustomerErrorResponse>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
