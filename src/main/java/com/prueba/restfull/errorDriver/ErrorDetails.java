package com.prueba.restfull.errorDriver;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {

    private String errorMessage;
    private String errorName;

    public ErrorDetails(String errorName, String errorMessage) {
        this.errorName = errorName;
        this.errorMessage = errorMessage;
    }
}
