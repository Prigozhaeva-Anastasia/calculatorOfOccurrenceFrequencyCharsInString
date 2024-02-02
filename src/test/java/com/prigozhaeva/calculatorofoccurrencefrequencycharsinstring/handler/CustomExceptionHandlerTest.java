package com.prigozhaeva.calculatorofoccurrencefrequencycharsinstring.handler;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomExceptionHandlerTest {
    private final CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();

    @Test
    void testHandleWithConstraintViolationException() {
        ConstraintViolationException exception = new ConstraintViolationException("Validation failed", null);
        ResponseError responseError = customExceptionHandler.handle(exception);

        assertEquals(400, responseError.status());
        assertEquals("Validation failed", responseError.message());
    }
}