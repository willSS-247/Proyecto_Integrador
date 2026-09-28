package com.uped.Notificaciones.modelo;

public class NotificacionCorreo extends Notificacion {
    private String direccionEmail;

    public NotificacionCorreo(String mensaje, String direccionEmail){
        super(mensaje);
        this.direccionEmail = direccionEmail;
    }
    @Override
    public void enviar(){
        System.out.println("Enviando Correo a " + direccionEmail + " | Mensaje " + mensaje);
    }
}
