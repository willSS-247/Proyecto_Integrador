package cajero;

public class Cuenta {

    private final String numeroCuenta;
    private final String titular;
    private double saldo;

    public Cuenta(String numeroCuenta, String titular, double saldoInicial) {
        if (numeroCuenta == null || numeroCuenta.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de cuenta es obligatorio.");
        }
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del titular es obligatorio.");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta.trim();
        this.titular = titular.trim();
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a $0.00.");
        }
        this.saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a $0.00.");
        }
        if (monto > this.saldo) {
            throw new IllegalStateException(
                String.format("Saldo insuficiente. Disponible actual: $%.2f", this.saldo)
            );
        }
        this.saldo -= monto;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String obtenerResumen() {
        return String.format(
            "Cuenta: %s%nTitular: %s%nSaldo disponible: $%.2f",
            numeroCuenta, titular, saldo
        );
    }
}