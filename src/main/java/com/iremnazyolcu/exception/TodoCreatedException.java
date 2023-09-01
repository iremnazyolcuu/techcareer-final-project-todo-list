package com.iremnazyolcu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CREATED)
public class TodoCreatedException extends RuntimeException {
    public TodoCreatedException(String message) {
        super(message);
    }
}