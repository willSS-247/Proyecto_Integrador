package com.uped.Notificaciones.modelo;

public class NotificacionSMS extends Notificacion {
    private String numeroTelefono;

    public NotificacionSMS(String mensaje, String numeroTelefono){
        super(mensaje);
        this.numeroTelefono = numeroTelefono;
    }
    @Override
    public void enviar(){
        System.out.println("Enviando SMS al nuemro " + numeroTelefono + "Mensaje " + mensaje);
    }
}
