package com.hackyeah.hy22.exception;

import com.hackyeah.hy22.api.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BasicExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementFoundException.class)
    public ResponseEntity<Object> handleNoSuchElementFoundException(NoSuchElementFoundException exception) {
        return new ResponseEntity<>(ApiError.builder()
                .errorMessage(exception.getMessage())
                .errorCode(exception.getStatus())
                .build(), exception.getStatus());
    }
}
