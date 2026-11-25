package com.uped.semana16.ejercicios;

public class EjFinally {

    static String probar(int x) {
        try {
            System.out.print("A");
            if (x == 0) {
                throw new IllegalStateException("cero");
            }
            System.out.print("B");
            return "R";
        } catch (IllegalStateException e) {
            System.out.print("C");
            return "E";
        } finally {
            System.out.print("F");
        }
    }

    public static void main(String[] args) {
        System.out.println(" -> " + probar(5));
        System.out.println(" -> " + probar(0));
    }
}