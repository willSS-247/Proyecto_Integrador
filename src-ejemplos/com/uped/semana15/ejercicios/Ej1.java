package ejercicios;

import javax.swing.JOptionPane;

public class Ej1 {

    public static void main(String[] args) {
        double saldo = 250.00;

        try {
            String entrada = JOptionPane.showInputDialog(
                null,
                String.format("Saldo actual: $%.2f%nIngrese el monto a retirar:", saldo),
                "Ejercicio 1 - Control de Saldo",
                JOptionPane.QUESTION_MESSAGE
            );

            if (entrada == null) {
                return;
            }

            double retiro = Double.parseDouble(entrada.trim());

            if (retiro <= 0) {
                throw new IllegalArgumentException("El monto debe ser mayor a $0.00.");
            }
            if (retiro > saldo) {
                throw new IllegalStateException(
                    String.format("Fondos insuficientes para retirar $%.2f.", retiro)
                );
            }

            saldo -= retiro;
            JOptionPane.showMessageDialog(
                null,
                String.format("Retiro aprobado.%nNuevo saldo: $%.2f", saldo),
                "Operación Exitosa",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException | IllegalStateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Validación de Cuenta", JOptionPane.WARNING_MESSAGE);
        }
    }
}