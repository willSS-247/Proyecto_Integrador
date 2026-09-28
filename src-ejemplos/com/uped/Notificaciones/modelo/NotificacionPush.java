package com.uped.Notificaciones.modelo;

public class NotificacionPush extends Notificacion {
    private String idDispositivo;

    public NotificacionPush(String mensaje, String idDispositivo) {
        super(mensaje);
        this.idDispositivo = idDispositivo;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando Push al dispositivo " + idDispositivo + " | Mensaje: " + mensaje);
    }
}
