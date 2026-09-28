package com.uped.musica.modelo;

public abstract class Instrumento {
    protected String tipo = "Generico";

    public abstract void tocar();

    public static String identificar(){
        return "Instrumento generico";
    }

    public final void mostrarTipo() {
        System.out.println("Tipo declarado: " + tipo);
    }
}
