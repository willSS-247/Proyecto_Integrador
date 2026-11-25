package gimnasio;

import javax.swing.JOptionPane;

public final class Entrada {

    private Entrada() {
    }

    public static String validarTexto(String valor, String nombreCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo '" + nombreCampo + "' no puede estar vacío.");
        }
        return valor.trim();
    }

    public static int validarEdad(String textoEdad) {
        String limpio = validarTexto(textoEdad, "Edad");
        int edad;
        try {
            edad = Integer.parseInt(limpio);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("La edad debe ser un número entero válido.");
        }
        if (edad < 14 || edad > 100) {
            throw new IllegalArgumentException("La edad permitida para inscripción es de 14 a 100 años.");
        }
        return edad;
    }

    public static int validarMeses(String textoMeses) {
        String limpio = validarTexto(textoMeses, "Duración (meses)");
        int meses;
        try {
            meses = Integer.parseInt(limpio);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("La cantidad de meses debe ser un número entero.");
        }
        if (meses < 1 || meses > 24) {
            throw new IllegalArgumentException("La duración debe estar entre 1 y 24 meses.");
        }
        return meses;
    }

    public static double calcularTotalMembresia(String plan, int meses) {
        double tarifaMensual = switch (plan) {
            case "Básico ($25/mes)" -> 25.00;
            case "Intermedio ($40/mes)" -> 40.00;
            case "VIP ($60/mes)" -> 60.00;
            default -> throw new IllegalArgumentException("Plan seleccionado no válido.");
        };

        double subtotal = tarifaMensual * meses;
        // 10% de descuento por inscripción semestral o mayor
        if (meses >= 6) {
            subtotal *= 0.90;
        }
        return subtotal;
    }

    public static String leerCadenaDialogo(String mensaje) {
        String dato = JOptionPane.showInputDialog(null, mensaje);
        return validarTexto(dato, "Entrada");
    }
}