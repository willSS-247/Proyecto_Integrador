package com.uped.semana16.ejercicios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Bienvenida extends JFrame {

    public Bienvenida() {
        super("Bienvenida");
        JLabel mensaje = new JLabel("Bienvenido al cajero", SwingConstants.CENTER);
        mensaje.setFont(new Font("SansSerif", Font.BOLD, 22));
        mensaje.setForeground(new Color(0x0B3D6E));
        getContentPane().setBackground(new Color(0xFCE9BF));
        add(mensaje, BorderLayout.CENTER);

        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Bienvenida().setVisible(true);
    }
}