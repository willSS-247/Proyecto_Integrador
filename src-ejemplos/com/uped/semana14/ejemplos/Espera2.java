package com.uped.semana14.ejemplos;

public class Espera2 {
    public static void main(String[] args) {
        System.out.println("Procesando reserva...");
        try {
            Thread.sleep(500);
            System.out.println("Listo");
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida");
        }

        try {
            Class.forName("Reserva Premium");
        } catch (ClassNotFoundException e) {
            System.out.println("No existe la clase: " + e.getMessage());
        }
    }
}
