package com.restfulwebservice.restfulwebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserWithNoPostsException extends RuntimeException {

    public UserWithNoPostsException(String message) { super(message); }
}
