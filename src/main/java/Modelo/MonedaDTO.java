package Modelo;


import java.time.LocalDateTime;

public class MonedaDTO {
    private String MonedaLocal;
    private LocalDateTime time;
    private String MonedaCambio;
    private Double MontoCambio;

    public MonedaDTO(String monedaLocal, LocalDateTime time, String monedaCambio, Double montoCambio) {
        MonedaLocal = monedaLocal;
        this.time = time;
        MonedaCambio = monedaCambio;
        MontoCambio = montoCambio;
    }

    public String getMonedaLocal() {
        return MonedaLocal;
    }

    public void setMonedaLocal(String monedaLocal) {
        MonedaLocal = monedaLocal;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMonedaCambio() {
        return MonedaCambio;
    }

    public void setMonedaCambio(String monedaCambio) {
        MonedaCambio = monedaCambio;
    }

    public Double getMontoCambio() {
        return MontoCambio;
    }

    public void setMontoCambio(Double montoCambio) {
        MontoCambio = montoCambio;
    }
}
