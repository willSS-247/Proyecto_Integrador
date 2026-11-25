package com.uped.semana16.recursos;

public class SinRecursos {

    public static void main(String[] args) {
        Impresora p = new Impresora("Caja 3");
        try {
            p.imprimir("Recibo #102");
        } finally {
            p.close();
        }
    }
}