package com.prueba.restfull.entity;

import com.prueba.restfull.errorDriver.personalizeException.ExceptionTipoDocumentoInvalid;

import java.util.Objects;

public enum TipoDocumento {

    CEDULA("CEDULA"),
    PASAPORT("PASAPORT");

    private String valor;

    TipoDocumento(String pasaport) {
    }

    static String getTipo(String tipo) {
        for (int i = 0; i < values().length; i++) {
            if (Objects.equals(values()[i].name(), tipo)) {
                return values()[i].valor;
            }
        }
        throw new ExceptionTipoDocumentoInvalid("TIPO DE DOCUMENTO NO VALIDO.");
    }
}
