package Vista;

import Controlador.Controlador_Moneda;
import Servicio.Moneda_Servicio;

import java.io.IOException;
import java.util.Scanner;

public class Vista_Menu {
    public static Controlador_Moneda controlador;

    public Vista_Menu(Controlador_Moneda controlador1){
        this.controlador = controlador1;
    }

    public static void main(String[] args) throws IOException {
        Moneda_Servicio servicio = new Moneda_Servicio();
        controlador = new Controlador_Moneda(servicio);
        mostrarMenu();
    }

    public static void mostrarMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú de Conversión de Monedas ===");
            System.out.println("1. Ver monedas y su tasa de cambio");
            System.out.println("2. Convertir moneda");
            System.out.println("3. Ver historial de cambios");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    controlador.ImprimirMonedas();
                    break;
                case 2:
                    convertirMoneda();
                    break;
                case 3:
                    controlador.mostrarHistorial();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        scanner.close();
    }

    private static void convertirMoneda() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la moneda local (por ejemplo, USD): ");
        String monedaLocal = scanner.next().toUpperCase();
        System.out.print("Ingrese la moneda de cambio (por ejemplo, EUR): ");
        String monedaCambio = scanner.next().toUpperCase();
        System.out.print("Ingrese el monto a convertir: ");
        double monto = scanner.nextDouble();
        controlador.ConvertirMoneda(monedaLocal, monedaCambio, monto);
    }

}
