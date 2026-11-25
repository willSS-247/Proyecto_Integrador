package com.uped.semana16.swing;

import com.uped.semana16.excepciones.Cuenta;
import com.uped.semana16.excepciones.MontoInvalidoException;
import com.uped.semana16.excepciones.SaldoInsuficienteException;
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
import javax.swing.SwingUtilities;

public class VentanaCajero extends JFrame {

    private Cuenta cuenta;
    private JLabel lblSaldo = new JLabel();
    private JTextField txtMonto = new JTextField();
    private JButton btnDepositar = new JButton("Depositar");
    private JButton btnRetirar = new JButton("Retirar");

    public VentanaCajero(Cuenta cuenta) {
        super("Cajero - " + cuenta.getTitular());
        this.cuenta = cuenta;

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        lblSaldo.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblSaldo.setForeground(new Color(0x1E7A46));

        panel.add(new JLabel("Saldo actual:"));
        panel.add(lblSaldo);
        panel.add(new JLabel("Monto:"));
        panel.add(txtMonto);
        panel.add(btnDepositar);
        panel.add(btnRetirar);
        add(panel);

        btnDepositar.addActionListener(e -> depositar());
        btnRetirar.addActionListener(e -> retirar());

        actualizarSaldo();
        setSize(340, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private int leerMonto() {
        return Integer.parseInt(txtMonto.getText().trim());
    }

    private void depositar() {
        try {
            cuenta.depositar(leerMonto());
            actualizarSaldo();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Escriba solo numeros",
                "Dato invalido",
                JOptionPane.ERROR_MESSAGE
            );
        } catch (MontoInvalidoException ex) {
            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Monto invalido",
                JOptionPane.WARNING_MESSAGE
            );
        } finally {
            limpiar();
        }
    }

    private void retirar() {
        try {
            cuenta.retirar(leerMonto());
            actualizarSaldo();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Escriba solo numeros",
                "Dato invalido",
                JOptionPane.ERROR_MESSAGE
            );
        } catch (SaldoInsuficienteException ex) {
            JOptionPane.showMessageDialog(
                this,
                ex.getMessage() + ". Faltan $" + ex.getFaltante(),
                "Saldo insuficiente",
                JOptionPane.WARNING_MESSAGE
            );
        } catch (MontoInvalidoException ex) {
            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Monto invalido",
                JOptionPane.WARNING_MESSAGE
            );
        } finally {
            limpiar();
        }
    }

    private void actualizarSaldo() {
        lblSaldo.setText("$" + cuenta.getSaldo());
    }

    private void limpiar() {
        txtMonto.setText("");
        txtMonto.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new VentanaCajero(new Cuenta("Ana", 100)).setVisible(true)
        );
    }
}