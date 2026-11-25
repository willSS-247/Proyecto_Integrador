package com.uped.semana16.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Contador extends JFrame implements ActionListener {

    private int clics = 0;
    private JLabel etiqueta = new JLabel("Clics: 0");
    private JButton boton = new JButton("Contar");

    public Contador() {
        super("Contador");
        setLayout(new FlowLayout());
        add(boton);
        add(etiqueta);
        boton.addActionListener(this);
        setSize(300, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clics++;
        etiqueta.setText("Clics: " + clics);
    }

    public static void main(String[] args) {
        new Contador().setVisible(true);
    }
}