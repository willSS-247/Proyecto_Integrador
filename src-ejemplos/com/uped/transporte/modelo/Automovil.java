package com.uped.transporte.modelo;

public class Automovil extends Vehiculo {
    private static final double TARIFA_kM = 0.05;

    public Automovil(String placa, double kilometrosRecorridos) {
        super(placa, kilometrosRecorridos);
    }
    @Override
    public double calcularCostoPeaje() {
        return kilometrosRecorridos * TARIFA_kM;
    }
}
