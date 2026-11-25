package com.uped.semana16.ejercicios;

public class LimiteExcedidoException extends Exception {

    private int limite;

    public LimiteExcedidoException(int monto, int limite) {
        super("El retiro de $" + monto + " supera el limite diario de $" + limite);
        this.limite = limite;
    }

    public int getLimite() {
        return limite;
    }
}