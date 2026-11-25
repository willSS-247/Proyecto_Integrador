package com.uped.semana16.swing;

import javax.swing.JFrame;

public class PrimeraVentana {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Cajero UPED");
        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}