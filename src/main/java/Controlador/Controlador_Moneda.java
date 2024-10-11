package Controlador;

import Modelo.MonedaDTO;
import Servicio.Moneda_Servicio;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Controlador_Moneda {

    private static Moneda_Servicio modelo;
    private final List<MonedaDTO> historial;

    public Controlador_Moneda(Moneda_Servicio modelo) {
        this.modelo = modelo;
        this.historial = new ArrayList<>();
    }

    public void ImprimirMonedas() throws IOException{
        modelo.ObtenerMonedasDisponibles();
    }

    public void ConvertirMoneda(String MonedaLocal, String MonedaCambio, Double MontoCambio){
        try {
            double resultado = modelo.ConvertirMoneda(MonedaLocal, MonedaCambio, MontoCambio);
            System.out.println("Monto convertido: " + resultado + " " + MontoCambio);
            MonedaDTO registro = new MonedaDTO(MonedaLocal, LocalDateTime.now(), MonedaCambio, resultado);
            historial.add(registro);
        } catch (IOException e) {
            System.out.println("Error al convertir la moneda: " + e.getMessage());
        }
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay registros de conversiones.");
            return;
        }

        System.out.println("\n=== Historial de Conversiones ===");
        for (MonedaDTO registro : historial) {
            System.out.println("Moneda Local: " + registro.getMonedaLocal() +
                    ", Moneda de Cambio: " + registro.getMonedaCambio() +
                    ", Monto Convertido: " + registro.getMontoCambio() +
                    ", Fecha y Hora: " + registro.getTime());
        }
        System.out.println("===============================");
    }


}
