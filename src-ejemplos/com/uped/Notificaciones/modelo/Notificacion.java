package com.uped.Notificaciones.modelo;

public abstract class Notificacion {
    protected String mensaje;

    public Notificacion(String mensaje){
        this.mensaje = mensaje;
    }
    public abstract void enviar();

    public final void registrarHistorial(){
        System.out.println("Historial guardado: Notificacón procesada.");
    }
}
