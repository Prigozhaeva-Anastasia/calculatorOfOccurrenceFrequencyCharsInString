package com.prigozhaeva.calculatorofoccurrencefrequencycharsinstring.handler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseError handle(ConstraintViolationException exception) {
        return new ResponseError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }
}
