package com.uped.proyecto;

import com.uped.proyecto.modelo.DocenteInvestigador;
import com.uped.proyecto.modelo.Gerente;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- PRUEBAS GUÍA 7 (Herencia Multinivel) ---");

        Gerente g = new Gerente("Marta Díaz", "05123456-7", 1200.0, 5);
        System.out.println(g);
        System.out.println("Beneficio Gerente: $" + g.calcularBeneficioAnual());

        System.out.println("\n--- TERCERA GENERACIÓN ---");
        DocenteInvestigador di = new DocenteInvestigador("Dr. Iván Reyes", "07321456-9", "Ingeniería de Software", 8, 4);
        System.out.println(di);
        System.out.println("Beneficio Docente Investigador: $" + di.calcularBeneficioAnual());
    }
}
