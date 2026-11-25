package com.uped.semana16.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Disenos {

    static JFrame flow() {
        JFrame f = new JFrame("FlowLayout");
        f.setLayout(new FlowLayout());
        for (String t : new String[]{"Uno", "Dos", "Tres", "Cuatro", "Cinco"}) {
            f.add(new JButton(t));
        }
        f.setSize(300, 120);
        return f;
    }

    static JFrame border() {
        JFrame f = new JFrame("BorderLayout");
        f.setLayout(new BorderLayout());
        f.add(new JButton("NORTH"), BorderLayout.NORTH);
        f.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        f.add(new JButton("WEST"), BorderLayout.WEST);
        f.add(new JButton("EAST"), BorderLayout.EAST);
        f.add(new JButton("CENTER"), BorderLayout.CENTER);
        f.setSize(320, 180);
        return f;
    }

    static JFrame grid() {
        JFrame f = new JFrame("GridLayout");
        f.setLayout(new GridLayout(2, 3, 5, 5));
        for (int i = 1; i <= 6; i++) {
            f.add(new JButton("Celda " + i));
        }
        f.setSize(320, 140);
        return f;
    }

    static JFrame absoluto() {
        JFrame f = new JFrame("Posiciones fijas");
        f.setLayout(null);
        JLabel lbl = new JLabel("Monto:");
        lbl.setBounds(20, 20, 60, 25);
        JTextField txt = new JTextField();
        txt.setBounds(90, 20, 150, 25);
        JButton btn = new JButton("Aceptar");
        btn.setBounds(90, 60, 150, 30);
        f.add(lbl);
        f.add(txt);
        f.add(btn);
        f.setSize(290, 150);
        return f;
    }

    static JFrame estilos() {
        JFrame f = new JFrame("Atributos");
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        f.getContentPane().setBackground(new Color(0xF3F6FA));

        JLabel titulo = new JLabel("Cooperativa UPED");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        titulo.setForeground(new Color(0x0B3D6E));

        JTextField txt = new JTextField("150", 8);
        txt.setFont(new Font("Monospaced", Font.PLAIN, 16));
        txt.setHorizontalAlignment(JTextField.RIGHT);

        JButton btn = new JButton("Confirmar");
        btn.setBackground(new Color(0xF2A900));
        btn.setPreferredSize(new Dimension(130, 36));
        btn.setToolTipText("Confirma la operacion");

        f.add(titulo);
        f.add(txt);
        f.add(btn);
        f.setSize(300, 140);
        return f;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame[] ventanas = {flow(), border(), grid(), absoluto(), estilos()};
            int offset = 0;
            for (JFrame v : ventanas) {
                v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                v.setLocation(120 + offset, 100 + offset);
                v.setVisible(true);
                offset += 45;
            }
        });
    }
}