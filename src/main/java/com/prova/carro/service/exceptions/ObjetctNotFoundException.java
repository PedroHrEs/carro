package com.prova.carro.service.exceptions;

public class ObjetctNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjetctNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjetctNotFoundException(String message) {
        super(message);
    }
}
