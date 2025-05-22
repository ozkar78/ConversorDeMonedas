/*
 * PASO 0: Recordar el paso a paso de la importación y uso de GSON para leer JSON
 */

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConsultarMoneda {

    // PASO 1: Definir la clave de API y la URL base del servicio
    private static final String API_KEY = "17e6cb2420c224ddf11b4fd0";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) throws IOException {

        // PASO 2: Construiremos la URL completa con las divisas que se quieran consultar
        String urlString = BASE_URL + monedaOrigen + "/" + monedaDestino;
        URL url = new URL(urlString);

        // PASO 3: Estableceremos una conexión HTTP con la URL construida
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        // PASO 4: Verificar que la respuesta del servidor sea OK (código 200)en postman
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            // Si no es OK, lanzar una excepción con el código de error
            throw new RuntimeException("Error en la API: Código " + responseCode);
        }

        // PASO 5: Leer la respuesta JSON desde la conexión
        Scanner scanner = new Scanner(url.openStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        // PASO 6: Parsear el JSON usando GSON para convertirlo de texto a datos desde una API
        JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();

        // PASO 7: Extraer y retornar el valor de "conversion_rate" como double
        return jsonResponse.get("conversion_rate").getAsDouble();
    }
}
