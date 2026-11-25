package com.uped.semana16.swing;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaComponentes extends JFrame {

    public VentanaComponentes() {
        super("Deposito");
        setLayout(new FlowLayout());
        add(new JLabel("Monto:"));
        add(new JTextField(10));
        add(new JButton("Depositar"));
        setSize(380, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new VentanaComponentes().setVisible(true);
    }
}