package com.prueba.restfull.errorDriver.personalizeException;

public class ExceptionDateEmpty extends RuntimeException{
    public ExceptionDateEmpty(String msg) {
        super(msg);
    }
}
