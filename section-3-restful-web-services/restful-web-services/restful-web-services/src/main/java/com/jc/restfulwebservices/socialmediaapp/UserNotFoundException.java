package com.jc.restfulwebservices.socialmediaapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) { // Constructor that accepts a message and passes it to super class (RuntimeException)
        super(message);
    }
}
