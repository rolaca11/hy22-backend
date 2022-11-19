package com.hackyeah.hy22.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
public class NoSuchElementFoundException extends RuntimeException {

    private final HttpStatus status = HttpStatus.NOT_FOUND;
    public NoSuchElementFoundException(String message) {
        super(message);
    }
    public HttpStatus getStatus() {
        return status;
    }
}
