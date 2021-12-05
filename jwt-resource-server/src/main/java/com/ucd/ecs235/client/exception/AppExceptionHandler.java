package com.ucd.ecs235.client.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiServiceException.class)
    public ResponseEntity<ApiServiceException> handleApiServiceException(ApiServiceException ex) {
        return new ResponseEntity<>(ex, ex.getHttpStatus());
    }
}
