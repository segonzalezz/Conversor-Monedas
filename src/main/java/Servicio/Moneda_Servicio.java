package Servicio;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Moneda_Servicio {

    private static final String URL_API = "https://v6.exchangerate-api.com/v6/644ac3f89166de767d041409/latest/USD";

    public static void ObtenerMonedasDisponibles() throws IOException {
        String url_str = URL_API;
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        //Obtener Atributos
        JsonObject jsonobjj = jsonobj.get("conversion_rates").getAsJsonObject();
        //Convertir a Gson
        Gson gson = new Gson();
        Map<String, Double> req_result = gson.fromJson(jsonobjj, Map.class);
        System.out.println("------------------Menu------------------");
        req_result.forEach((moneda, tasa) -> {
            System.out.println("Moneda: " + moneda + ", Tasa: " + tasa);
        });
        System.out.println("------------------Close------------------");
    }

    public double ConvertirMoneda(String monedaLocal, String monedaCambio, double monto) throws IOException {
        String urlStr = "https://v6.exchangerate-api.com/v6/644ac3f89166de767d041409" + "/pair/" + monedaLocal + "/" + monedaCambio;
        URL url = new URL(urlStr);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.connect();
        if (request.getResponseCode() == HttpURLConnection.HTTP_OK) {
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();
            double tasaCambio = jsonobj.get("conversion_rate").getAsDouble();
            double montoConvertido = monto * tasaCambio;
            return montoConvertido;
        } else {
            throw new IOException("Error en la solicitud HTTP: " + request.getResponseCode());
        }
    }


}
