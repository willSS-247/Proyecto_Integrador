package ejercicios;

import javax.swing.JOptionPane;

public class Inscripcion {

    public static class EdadInvalidaException extends Exception {
        public EdadInvalidaException(String mensaje) {
            super(mensaje);
        }
    }

    public static void verificarEdad(String nombre, int edad) throws EdadInvalidaException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del aspirante es obligatorio.");
        }
        if (edad < 18 || edad > 99) {
            throw new EdadInvalidaException(
                "Edad fuera de rango (" + edad + " años). Se requiere tener entre 18 y 99 años."
            );
        }
    }

    public static void main(String[] args) {
        try {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del participante:");
            if (nombre == null) {
                return;
            }

            String textoEdad = JOptionPane.showInputDialog(null, "Ingrese la edad de " + nombre.trim() + ":");
            if (textoEdad == null) {
                return;
            }

            int edad = Integer.parseInt(textoEdad.trim());
            verificarEdad(nombre, edad);

            JOptionPane.showMessageDialog(
                null,
                "Inscripción aprobada para " + nombre.trim() + " (" + edad + " años).",
                "Registro Válido",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La edad debe ser un número entero.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (EdadInvalidaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Edad No Permitida", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Dato Faltante", JOptionPane.WARNING_MESSAGE);
        }
    }
}