package ejercicios;

import javax.swing.JOptionPane;

public class Ej4 {

    public static double calcularCuota(double montoTotal, int numeroCuotas) {
        if (montoTotal <= 0) {
            throw new IllegalArgumentException("El monto total debe ser mayor a $0.00.");
        }
        if (numeroCuotas <= 0) {
            throw new ArithmeticException("El número de cuotas debe ser mayor a cero (no se puede dividir entre " + numeroCuotas + ").");
        }
        return montoTotal / numeroCuotas;
    }

    public static void main(String[] args) {
        try {
            String txtMonto = JOptionPane.showInputDialog(null, "Ingrese el monto total a financiar ($):");
            if (txtMonto == null) {
                return;
            }

            String txtCuotas = JOptionPane.showInputDialog(null, "Ingrese la cantidad de cuotas mensuales:");
            if (txtCuotas == null) {
                return;
            }

            double monto = Double.parseDouble(txtMonto.trim());
            int cuotas = Integer.parseInt(txtCuotas.trim());

            double valorCuota = calcularCuota(monto, cuotas);

            JOptionPane.showMessageDialog(
                null,
                String.format(
                    "Resumen de Financiamiento:%nMonto total: $%.2f%nPlazo: %d cuota(s)%nValor por cuota: $%.2f",
                    monto, cuotas, valorCuota
                ),
                "Cálculo de Cuotas",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error Aritmético", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Dato Inválido", JOptionPane.WARNING_MESSAGE);
        }
    }
}