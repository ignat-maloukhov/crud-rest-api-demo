package demo.malouhov.crudrestapidemo.exception;

import java.time.LocalDateTime;


public record CustomerErrorResponse(
        LocalDateTime timestamp,
        int statusCode,
        String message,
        String path) {

}