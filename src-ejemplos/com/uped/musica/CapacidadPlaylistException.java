package com.uped.musica;

public class CapacidadPlaylistException extends Exception {

    private final String tituloCancion;
    private final int capacidadMaxima;

    public CapacidadPlaylistException(String tituloCancion, int capacidadMaxima) {
        super("No se puede agregar '" + tituloCancion
                + "': la playlist alcanzo su limite maximo de "
                + capacidadMaxima + " canciones.");
        this.tituloCancion = tituloCancion;
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getTituloCancion() {
        return tituloCancion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}