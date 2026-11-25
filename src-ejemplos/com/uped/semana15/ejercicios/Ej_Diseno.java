package ejercicios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Ej_Diseno {

    private static Icon crearIconoInstitucional() {
        int tam = 48;
        BufferedImage imagen = new BufferedImage(tam, tam, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imagen.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo circular azul cobalto
        g2.setColor(new Color(29, 78, 216));
        g2.fillRoundRect(2, 2, tam - 4, tam - 4, 14, 14);

        // Iniciales centradas
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("SansSerif", Font.BOLD, 18));
        g2.drawString("G15", 8, 31);
        g2.dispose();

        return new ImageIcon(imagen);
    }

    private static void aplicarTemaPersonalizado() {
        UIManager.put("OptionPane.background", new Color(248, 250, 252));
        UIManager.put("Panel.background", new Color(248, 250, 252));
        UIManager.put("OptionPane.messageFont", new Font("SansSerif", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("SansSerif", Font.BOLD, 12));
    }

    public static void main(String[] args) {
        aplicarTemaPersonalizado();
        Icon icono = crearIconoInstitucional();

        String[] botones = {"Abrir Panel Principal", "Cerrar"};
        int opcion = JOptionPane.showOptionDialog(
            null,
            "Sistema configurado con fuentes, paleta e ícono personalizados.\nEstudiante: William Nahum Sorto Salgado (SS-69740-25)",
            "Diseño Personalizado Swing - Guía 15",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            icono,
            botones,
            botones[0]
        );

        if (opcion == 0) {
            SwingUtilities.invokeLater(() -> {
                JFrame ventana = new JFrame("Panel Estilizado - Guía 15");
                ventana.setSize(440, 230);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventana.setLocationRelativeTo(null);
                ventana.setLayout(new BorderLayout(10, 10));

                JPanel tarjeta = new JPanel(new BorderLayout(8, 8));
                tarjeta.setBackground(Color.WHITE);
                tarjeta.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(15, 15, 15, 15),
                    BorderFactory.createLineBorder(new Color(203, 213, 225), 1, true)
                ));

                JLabel lblEncabezado = new JLabel("Interfaz Swing Personalizada", icono, JLabel.LEFT);
                lblEncabezado.setFont(new Font("SansSerif", Font.BOLD, 16));
                lblEncabezado.setForeground(new Color(15, 23, 42));
                lblEncabezado.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

                JLabel lblDetalle = new JLabel("<html>Uso de <b>Font</b>, <b>Color</b>, <b>UIManager</b> e <b>ImageIcon</b> generado en memoria.</html>");
                lblDetalle.setFont(new Font("SansSerif", Font.PLAIN, 13));
                lblDetalle.setBorder(BorderFactory.createEmptyBorder(0, 12, 10, 12));

                JPanel pie = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                pie.setBackground(Color.WHITE);
                JButton btnProbarDialogo = new JButton("Probar Alerta");
                btnProbarDialogo.setBackground(new Color(29, 78, 216));
                btnProbarDialogo.setForeground(Color.WHITE);
                btnProbarDialogo.setFocusPainted(false);
                btnProbarDialogo.addActionListener(e -> JOptionPane.showMessageDialog(
                    ventana,
                    "Diálogo modal lanzado con estilo personalizado.",
                    "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE,
                    icono
                ));

                pie.add(btnProbarDialogo);
                tarjeta.add(lblEncabezado, BorderLayout.NORTH);
                tarjeta.add(lblDetalle, BorderLayout.CENTER);
                tarjeta.add(pie, BorderLayout.SOUTH);

                ventana.add(tarjeta, BorderLayout.CENTER);
                ventana.setVisible(true);
            });
        }
    }
}