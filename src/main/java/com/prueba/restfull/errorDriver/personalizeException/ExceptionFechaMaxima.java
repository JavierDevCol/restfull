package com.prueba.restfull.errorDriver.personalizeException;

public class ExceptionFechaMaxima extends RuntimeException {
    public ExceptionFechaMaxima(String message) {
        super(message);
    }
}
