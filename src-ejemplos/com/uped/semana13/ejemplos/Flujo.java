package com.uped.semana13.ejemplos;

public class Flujo {
    public static void main(String[] args) {
        System.out.println("A");
        try {
            System.out.println("B");
            int x = 10 / 0; // Aquí ocurre el fallo
            System.out.println("C"); // Nunca se imprime
        } catch (ArithmeticException e) {
            System.out.println("D");
        }
        System.out.println("E");
    }
}