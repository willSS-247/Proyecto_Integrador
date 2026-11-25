package com.uped.semana16.excepciones;

public class MontoInvalidoException extends RuntimeException {

    public MontoInvalidoException(String mensaje) {
        super(mensaje);
    }
}