package com.iremnazyolcu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class TodoUnAuthorizedException extends RuntimeException {
    public TodoUnAuthorizedException(String message) {
        super(message);
    }
}