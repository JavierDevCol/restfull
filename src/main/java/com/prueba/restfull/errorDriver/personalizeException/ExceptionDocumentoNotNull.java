package com.prueba.restfull.errorDriver.personalizeException;

public class ExceptionDocumentoNotNull extends RuntimeException{
    public ExceptionDocumentoNotNull(String msg) {
        super(msg);
    }
}
