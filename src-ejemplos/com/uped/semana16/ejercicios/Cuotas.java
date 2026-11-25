package com.uped.semana16.ejercicios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Cuotas extends JFrame {

    private JTextField txtMonto = new JTextField();
    private JTextField txtMeses = new JTextField();
    private JLabel lblCuota = new JLabel("Cuota: -", SwingConstants.CENTER);
    private JButton btnCalcular = new JButton("Calcular");

    public Cuotas() {
        super("Calculadora de cuotas");
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Plan de pagos", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        titulo.setOpaque(true);
        titulo.setBackground(new Color(0x0B3D6E));
        titulo.setForeground(Color.WHITE);
        add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridLayout(3, 2, 8, 8));
        centro.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 12));
        centro.add(new JLabel("Monto ($):"));
        centro.add(txtMonto);
        centro.add(new JLabel("Meses:"));
        centro.add(txtMeses);
        centro.add(new JLabel());
        centro.add(btnCalcular);
        add(centro, BorderLayout.CENTER);

        lblCuota.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(lblCuota, BorderLayout.SOUTH);

        btnCalcular.addActionListener(e -> calcular());

        setSize(330, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    static int calcularCuota(int monto, int meses) {
        if (meses <= 0) {
            throw new IllegalArgumentException("Los meses deben ser positivos");
        }
        return monto / meses;
    }

    private void calcular() {
        try {
            int monto = Integer.parseInt(txtMonto.getText().trim());
            int meses = Integer.parseInt(txtMeses.getText().trim());
            lblCuota.setText("Cuota: $" + calcularCuota(monto, meses));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Escriba solo numeros",
                "Dato invalido",
                JOptionPane.ERROR_MESSAGE
            );
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Dato invalido",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new Cuotas().setVisible(true);
    }
}