package cajero;

import javax.swing.JOptionPane;

public class MenuCajero {

    private final Cuenta cuenta;

    public MenuCajero(Cuenta cuenta) {
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta asociada no puede ser nula.");
        }
        this.cuenta = cuenta;
    }

    public void iniciar() {
        String[] opciones = {"Consultar Saldo", "Depositar", "Retirar", "Salir"};
        boolean activo = true;

        while (activo) {
            int seleccion = JOptionPane.showOptionDialog(
                null,
                "Bienvenido, " + cuenta.getTitular() + "\nSeleccione una operación:",
                "Cajero Automático - UPED",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (seleccion == -1 || seleccion == 3) {
                activo = false;
                Dialogos.mostrarInfo("Sesión Finalizada", "Gracias por utilizar el cajero.");
                continue;
            }

            try {
                switch (seleccion) {
                    case 0 -> Dialogos.mostrarInfo("Estado de Cuenta", cuenta.obtenerResumen());
                    case 1 -> procesarDeposito();
                    case 2 -> procesarRetiro();
                    default -> activo = false;
                }
            } catch (NumberFormatException e) {
                Dialogos.mostrarError("Error de Formato", e.getMessage());
            } catch (IllegalArgumentException e) {
                Dialogos.mostrarError("Dato Inválido", e.getMessage());
            } catch (IllegalStateException e) {
                Dialogos.mostrarError("Operación Rechazada", e.getMessage());
            } catch (Exception e) {
                Dialogos.mostrarError("Error Inesperado", "Ocurrió un problema: " + e.getMessage());
            }
        }
    }

    private void procesarDeposito() {
        double monto = Dialogos.leerMonto("Depósito", "Ingrese el monto a depositar ($):");
        if (monto < 0) {
            return;
        }
        cuenta.depositar(monto);
        Dialogos.mostrarInfo(
            "Depósito Exitoso",
            String.format("Se depositaron $%.2f.%nNuevo saldo: $%.2f", monto, cuenta.getSaldo())
        );
    }

    private void procesarRetiro() {
        double monto = Dialogos.leerMonto("Retiro", "Ingrese el monto a retirar ($):");
        if (monto < 0) {
            return;
        }
        cuenta.retirar(monto);
        Dialogos.mostrarInfo(
            "Retiro Exitoso",
            String.format("Se retiraron $%.2f.%nNuevo saldo: $%.2f", monto, cuenta.getSaldo())
        );
    }

    public static void main(String[] args) {
        Cuenta cuentaDemo = new Cuenta("001-69740-25", "William Nahum Sorto Salgado", 500.00);
        MenuCajero cajero = new MenuCajero(cuentaDemo);
        cajero.iniciar();
    }
}