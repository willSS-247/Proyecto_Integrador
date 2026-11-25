package com.uped.musica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class VentanaPlaylist extends JFrame {

    private final PlaylistMusical playlist;
    private final JTextField txtTitulo;
    private final JTextField txtDuracion;
    private final JLabel lblEstado;

    public VentanaPlaylist() {
        this.playlist = new PlaylistMusical("Favoritas UPED", 3);

        setTitle("Gestion de Playlist - Modulo Musica");
        setSize(520, 270);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel lblEncabezado = new JLabel(
                "Playlist: " + playlist.getNombrePlaylist(), SwingConstants.CENTER);
        lblEncabezado.setOpaque(true);
        lblEncabezado.setBackground(new Color(0x0B3D6E));
        lblEncabezado.setForeground(Color.WHITE);
        lblEncabezado.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblEncabezado.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        add(lblEncabezado, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new GridLayout(3, 2, 8, 8));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(5, 14, 5, 14));

        panelCentral.add(new JLabel("Titulo de la cancion:"));
        txtTitulo = new JTextField();
        panelCentral.add(txtTitulo);

        panelCentral.add(new JLabel("Duracion (segundos):"));
        txtDuracion = new JTextField();
        panelCentral.add(txtDuracion);

        panelCentral.add(new JLabel());
        JButton btnAgregar = new JButton("Agregar cancion");
        btnAgregar.addActionListener(e -> registrarCancion());
        panelCentral.add(btnAgregar);

        add(panelCentral, BorderLayout.CENTER);

        lblEstado = new JLabel(
                "Canciones registradas: 0 / " + playlist.getCapacidadMaxima(),
                SwingConstants.CENTER);
        lblEstado.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblEstado.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        add(lblEstado, BorderLayout.SOUTH);
    }

    private void registrarCancion() {
        try {
            String titulo = txtTitulo.getText();
            int duracion = Integer.parseInt(txtDuracion.getText().trim());

            playlist.agregarCancion(titulo, duracion);

            lblEstado.setForeground(new Color(0x1E7A46));
            lblEstado.setText("Canciones registradas: "
                    + playlist.getCantidadActual() + " / " + playlist.getCapacidadMaxima());

            JOptionPane.showMessageDialog(
                    this,
                    "Cancion agregada correctamente a la playlist.",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "La duracion debe ser un numero entero valido en segundos.",
                    "Dato no numerico",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Validacion de datos",
                    JOptionPane.WARNING_MESSAGE);
        } catch (CapacidadPlaylistException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Capacidad maxima alcanzada",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            txtTitulo.setText("");
            txtDuracion.setText("");
            txtTitulo.requestFocus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPlaylist().setVisible(true));
    }
}