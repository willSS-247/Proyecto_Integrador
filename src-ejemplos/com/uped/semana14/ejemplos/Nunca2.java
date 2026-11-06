package com.uped.semana14.ejemplos;

public class Nunca2 {
    public static void main(String[] args) {
        try {
            System.out.println("Hola");
        } catch (ArithmeticException e) {
            System.out.println("No ocurre");
        }
    }
}
