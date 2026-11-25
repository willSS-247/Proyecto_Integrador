package com.uped.musica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaylistMusical {

    private final String nombrePlaylist;
    private final int capacidadMaxima;
    private final List<String> canciones;

    public PlaylistMusical(String nombrePlaylist, int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad maxima debe ser mayor que cero: " + capacidadMaxima);
        }
        this.nombrePlaylist = nombrePlaylist;
        this.capacidadMaxima = capacidadMaxima;
        this.canciones = new ArrayList<>();
    }

    public void agregarCancion(String titulo, int duracionSegundos)
            throws CapacidadPlaylistException {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo de la cancion no puede estar vacio.");
        }
        if (duracionSegundos <= 0) {
            throw new IllegalArgumentException(
                    "La duracion debe ser mayor a 0 segundos (valor ingresado: "
                    + duracionSegundos + ").");
        }
        if (canciones.size() >= capacidadMaxima) {
            throw new CapacidadPlaylistException(titulo.trim(), capacidadMaxima);
        }

        canciones.add(titulo.trim() + " (" + duracionSegundos + "s)");
    }

    public String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getCantidadActual() {
        return canciones.size();
    }

    public List<String> getCanciones() {
        return Collections.unmodifiableList(canciones);
    }
}