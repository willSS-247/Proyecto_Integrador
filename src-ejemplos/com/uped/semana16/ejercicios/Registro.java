package com.uped.semana16.ejercicios;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registro extends JFrame {

    private JTextField txtNombre = new JTextField();
    private JTextField txtEdad = new JTextField();
    private JLabel lblResultado = new JLabel(" ");
    private JButton btnRegistrar = new JButton("Registrar");

    public Registro() {
        super("Registro de socio");

        JPanel panel = new JPanel(new GridLayout(4, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Edad:"));
        panel.add(txtEdad);
        panel.add(new JLabel());
        panel.add(btnRegistrar);
        panel.add(new JLabel("Resultado:"));
        panel.add(lblResultado);
        add(panel);

        btnRegistrar.addActionListener(e -> registrar());

        setSize(360, 190);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    static int validarEdad(String texto) throws EdadInvalidaException {
        int edad;
        try {
            edad = Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            throw new EdadInvalidaException("La edad debe ser un numero");
        }
        if (edad < 16 || edad > 80) {
            throw new EdadInvalidaException("Edad fuera de rango: " + edad);
        }
        return edad;
    }

    private void registrar() {
        try {
            int edad = validarEdad(txtEdad.getText());
            lblResultado.setForeground(new Color(0x1E7A46));
            lblResultado.setText(txtNombre.getText() + " (" + edad + ") registrado");
        } catch (EdadInvalidaException ex) {
            lblResultado.setForeground(new Color(0xB23A2E));
            lblResultado.setText(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Registro().setVisible(true);
    }
}