package com.prueba.restfull.errorDriver.personalizeException;

public class ExceptionTipoDocumentoInvalid extends RuntimeException{
    public ExceptionTipoDocumentoInvalid(String message) {
        super(message);
    }
}
