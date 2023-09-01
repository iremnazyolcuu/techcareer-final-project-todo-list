package com.iremnazyolcu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TodoBadRequestException extends RuntimeException {
    public TodoBadRequestException(String message) {
        super(message);
    }
}