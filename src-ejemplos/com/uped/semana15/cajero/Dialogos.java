package cajero;

import javax.swing.JOptionPane;

public final class Dialogos {

    private Dialogos() {
    }

    public static void mostrarInfo(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static String leerTexto(String titulo, String mensaje) {
        String entrada = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
        if (entrada == null) {
            return null; // Usuario canceló
        }
        if (entrada.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo no puede quedar vacío.");
        }
        return entrada.trim();
    }

    public static double leerMonto(String titulo, String mensaje) {
        String entrada = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
        if (entrada == null) {
            return -1; // Usuario canceló
        }
        String textoLimpio = entrada.trim();
        if (textoLimpio.isEmpty()) {
            throw new IllegalArgumentException("Debe ingresar un monto numérico.");
        }
        double monto;
        try {
            monto = Double.parseDouble(textoLimpio);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Formato numérico inválido: '" + textoLimpio + "'.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
        return monto;
    }
}