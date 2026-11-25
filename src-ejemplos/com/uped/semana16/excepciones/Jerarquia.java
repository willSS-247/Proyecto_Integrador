package com.uped.semana16.excepciones;

/**
 * Bloque III - Verificacion de jerarquia checked/unchecked con instanceof.
 * Asignatura: Programacion III - Semana 16
 * @author Sorto Salgado, William Nahum (SS-69740-25)
 */
public class Jerarquia {

    public static void main(String[] args) {
        Exception a = new SaldoInsuficienteException("x", 1);
        RuntimeException b = new MontoInvalidoException("y");

        System.out.println(a instanceof Exception);
        System.out.println(a instanceof RuntimeException);
        System.out.println(b instanceof RuntimeException);
        System.out.println(a);
    }
}