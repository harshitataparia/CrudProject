package com.honeywell.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeNotFoundException extends RuntimeException {

    public  EmployeNotFoundException(String exception)
    {
        super(exception);
    }
}
