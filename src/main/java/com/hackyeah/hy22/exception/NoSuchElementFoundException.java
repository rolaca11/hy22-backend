package com.hackyeah.hy22.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
public class NoSuchElementFoundException extends RuntimeException {
    public NoSuchElementFoundException(String message) {
        super(message);
    }
}
