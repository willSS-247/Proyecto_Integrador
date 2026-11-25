package com.uped.semana16.ejercicios;

import com.uped.semana16.excepciones.SaldoInsuficienteException;

public class CajeroLmite {

    private int saldo;
    private int retiradoHoy = 0;
    private static final int LIMITE = 200;

    public CajeroLmite(int saldo) {
        this.saldo = saldo;
    }

    public void retirar(int monto) throws LimiteExcedidoException, SaldoInsuficienteException {
        if (retiradoHoy + monto > LIMITE) {
            throw new LimiteExcedidoException(monto, LIMITE);
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente", monto - saldo);
        }
        saldo -= monto;
        retiradoHoy += monto;
    }

    public int getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        CajeroLmite c = new CajeroLmite(500);
        int[] montos = {150, 80, 40};

        for (int m : montos) {
            try {
                c.retirar(m);
                System.out.println("Retiro de $" + m + " -> saldo $" + c.getSaldo());
            } catch (LimiteExcedidoException e) {
                System.out.println(e.getMessage());
            } catch (SaldoInsuficienteException e) {
                System.out.println(e.getMessage() + ": faltan $" + e.getFaltante());
            }
        }
    }
}