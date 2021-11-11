package com.mvp.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class ConstraintViolationException  extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Object fieldValue;


    private static final long serialVersionUID = 1L;

    public ConstraintViolationException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s can not be empty or null %s: '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
