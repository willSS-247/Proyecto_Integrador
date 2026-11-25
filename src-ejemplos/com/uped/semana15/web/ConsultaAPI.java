package web;

import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ConsultaApi {

    private static final HttpClient CLIENTE = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10))
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build();

    public static String consultarGet(String url) throws IOException, InterruptedException {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("La URL de consulta no puede estar vacía.");
        }
        String urlLimpia = url.trim();
        if (!urlLimpia.startsWith("http://") && !urlLimpia.startsWith("https://")) {
            throw new IllegalArgumentException("La URL debe iniciar con http:// o https://");
        }

        HttpRequest solicitud = HttpRequest.newBuilder()
            .uri(URI.create(urlLimpia))
            .timeout(Duration.ofSeconds(10))
            .header("Accept", "application/json")
            .header("User-Agent", "Java-HttpClient-UPED-Guia15")
            .GET()
            .build();

        HttpResponse<String> respuesta = CLIENTE.send(solicitud, HttpResponse.BodyHandlers.ofString());

        int codigo = respuesta.statusCode();
        if (codigo < 200 || codigo >= 300) {
            throw new IOException("El servidor respondió con código HTTP " + codigo);
        }

        return "Código HTTP: " + codigo + "\n----------------------------------------\n" + respuesta.body();
    }

    public static void main(String[] args) {
        String urlDefecto = "https://jsonplaceholder.typicode.com/users/1";
        String urlIngresada = (String) JOptionPane.showInputDialog(
            null,
            "Ingrese la URL de la API REST a consultar:",
            "Consulta HTTP con HttpClient",
            JOptionPane.QUESTION_MESSAGE,
            null,
            null,
            urlDefecto
        );

        if (urlIngresada == null) {
            return;
        }

        try {
            String resultado = consultarGet(urlIngresada);

            JTextArea areaRespuesta = new JTextArea(resultado);
            areaRespuesta.setEditable(false);
            areaRespuesta.setFont(new Font("Monospaced", Font.PLAIN, 12));
            areaRespuesta.setLineWrap(true);
            areaRespuesta.setWrapStyleWord(true);

            JScrollPane scroll = new JScrollPane(areaRespuesta);
            scroll.setPreferredSize(new Dimension(480, 260));

            JOptionPane.showMessageDialog(
                null,
                scroll,
                "Respuesta de la API",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "URL Inválida", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                null,
                "Error de red o respuesta HTTP:\n" + e.getMessage(),
                "Error de Conexión",
                JOptionPane.ERROR_MESSAGE
            );
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            JOptionPane.showMessageDialog(null, "La consulta fue interrumpida.", "Interrupción", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}