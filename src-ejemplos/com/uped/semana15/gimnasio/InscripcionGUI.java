package gimnasio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class InscripcionGUI extends JFrame {

    private final JTextField txtNombre;
    private final JTextField txtEdad;
    private final JComboBox<String> cmbPlan;
    private final JTextField txtMeses;
    private final JTextArea txtHistorial;
    private int contadorSocios = 0;

    public InscripcionGUI() {
        setTitle("Registro de Socios - Gimnasio FitUPED");
        setSize(540, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Encabezado
        JLabel lblTitulo = new JLabel("Inscripción de Nuevos Socios", JLabel.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 17));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel de formulario
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 8, 8));
        panelForm.setBorder(BorderFactory.createTitledBorder("Datos del Socio"));

        txtNombre = new JTextField();
        txtEdad = new JTextField();
        cmbPlan = new JComboBox<>(new String[]{
            "Básico ($25/mes)",
            "Intermedio ($40/mes)",
            "VIP ($60/mes)"
        });
        txtMeses = new JTextField("1");

        panelForm.add(new JLabel("Nombre completo:"));
        panelForm.add(txtNombre);
        panelForm.add(new JLabel("Edad (14 - 100):"));
        panelForm.add(txtEdad);
        panelForm.add(new JLabel("Plan de entrenamiento:"));
        panelForm.add(cmbPlan);
        panelForm.add(new JLabel("Meses a contratar (6+ = 10% desc.):"));
        panelForm.add(txtMeses);

        // Area de comprobantes generados
        txtHistorial = new JTextArea();
        txtHistorial.setEditable(false);
        txtHistorial.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtHistorial.setBackground(new Color(248, 250, 252));
        JScrollPane scrollHistorial = new JScrollPane(txtHistorial);
        scrollHistorial.setBorder(BorderFactory.createTitledBorder("Socios Registrados"));

        JPanel panelCentro = new JPanel(new BorderLayout(8, 8));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 12));
        panelCentro.add(panelForm, BorderLayout.NORTH);
        panelCentro.add(scrollHistorial, BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 8));
        JButton btnRegistrar = new JButton("Registrar Socio");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnSalir = new JButton("Salir");

        btnRegistrar.addActionListener(e -> registrarSocio());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnSalir.addActionListener(e -> dispose());

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void registrarSocio() {
        try {
            String nombre = Entrada.validarTexto(txtNombre.getText(), "Nombre completo");
            int edad = Entrada.validarEdad(txtEdad.getText());
            String plan = (String) cmbPlan.getSelectedItem();
            int meses = Entrada.validarMeses(txtMeses.getText());
            double total = Entrada.calcularTotalMembresia(plan, meses);

            contadorSocios++;
            String registro = String.format(
                "#%02d | %s (%d años) | %s | %d mes(es) | Total: $%.2f%n",
                contadorSocios, nombre, edad, plan, meses, total
            );
            txtHistorial.append(registro);

            JOptionPane.showMessageDialog(
                this,
                "Inscripción completada con éxito.\nTotal a pagar: $" + String.format("%.2f", total),
                "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE
            );
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error Numérico", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Validación", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            txtNombre.requestFocusInWindow();
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEdad.setText("");
        cmbPlan.setSelectedIndex(0);
        txtMeses.setText("1");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InscripcionGUI().setVisible(true));
    }
}