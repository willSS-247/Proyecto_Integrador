package com.uped.Notificaciones;
import com.uped.Notificaciones.modelo.*;

public class MainNotificacion {
    public static void main(String[] args) {
        System.out.println("--- PRUEBA GUÍA 8 (Sistema de Notificaciones) ---");
        Notificacion[] notificaciones = {
                new NotificacionCorreo("Bienvenido al sistema", "usuario@uped.edu.sv"),
                new NotificacionSMS("Tu código es 1234", "7777-8888"),
                new NotificacionPush("Nueva actualización disponible", "Device_A14")
        };

        for (Notificacion n : notificaciones) {
            n.enviar();
            n.registrarHistorial();
            System.out.println("-------------------------------------------------");
        }
    }
}
