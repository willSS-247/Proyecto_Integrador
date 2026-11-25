package com.uped.semana16.ejercicios;

import com.uped.semana16.excepciones.MontoInvalidoException;

public class Ticket implements AutoCloseable {

    private int numero;

    public Ticket(int numero) {
        this.numero = numero;
        System.out.println("Abre ticket " + numero);
    }

    public void cobrar(int monto) {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto invalido: " + monto);
        }
        System.out.println("Ticket " + numero + " cobra $" + monto);
    }

    @Override
    public void close() {
        System.out.println("Cierra ticket " + numero);
    }

    public static void main(String[] args) {
        int[] montos = {25, -3};
        for (int i = 0; i < montos.length; i++) {
            try (Ticket t = new Ticket(i + 1)) {
                t.cobrar(montos[i]);
            } catch (MontoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}