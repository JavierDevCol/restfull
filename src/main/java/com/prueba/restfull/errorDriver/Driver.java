package com.prueba.restfull.errorDriver;


import com.prueba.restfull.errorDriver.personalizeException.ExceptionNotFindObj;
import com.prueba.restfull.errorDriver.personalizeException.ExceptionObjectDupliucate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class Driver implements WebExceptionHandler {

    private static final ConcurrentHashMap<String, HttpStatus> CODIGOS_ESTADO = new ConcurrentHashMap<>();
    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "OcurriÃ³ un error favor contactar al administrador.";

    public Driver() {
        CODIGOS_ESTADO.put(ExceptionNotFindObj.class.getSimpleName(), HttpStatus.NOT_FOUND);
        CODIGOS_ESTADO.put(ExceptionObjectDupliucate.class.getSimpleName(), HttpStatus.CONFLICT);
    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

        String  excepcionNombre= ex.getClass().getSimpleName();
        String mensaje = ex.getMessage();
        HttpStatus codigo = CODIGOS_ESTADO.get(excepcionNombre);
        if (codigo != null) {
            ErrorDetails error = new ErrorDetails(excepcionNombre, mensaje);
        } else {
            ErrorDetails error = new ErrorDetails(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
        }
        exchange.getResponse().setStatusCode(codigo);
        return exchange.getResponse().setComplete();
    }
}