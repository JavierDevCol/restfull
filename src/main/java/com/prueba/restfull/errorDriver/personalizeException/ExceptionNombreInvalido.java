package com.prueba.restfull.errorDriver.personalizeException;

public class ExceptionNombreInvalido extends RuntimeException{
    public ExceptionNombreInvalido(String message) {
        super(message);
    }
}
