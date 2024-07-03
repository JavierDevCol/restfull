package com.prueba.restfull.errorDriver.personalizeException;

public class ExceptionDefault extends Exception{
    public ExceptionDefault() {
        super("OCURRIO UN ERROR, PORFAVOR CONTACTE AL ADMINISTRADOR DE LA APLICACION.");
    }
}
