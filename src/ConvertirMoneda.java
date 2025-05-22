

import java.util.Scanner;

public class ConvertirMoneda {

    public static void convertir(String monedaOrigen, String monedaDestino, ConsultarMoneda consulta, Scanner scanner) {
        /*
         * ==============================================
         * MANUAL PRACTICO PARA REALIZAR LA CONVERSIÓN DE MONEDAS
         * Ejemplo:
         * - monedaOrigen: Código de moneda inicial (ej: "USD")
         * - monedaDestino: Código de moneda objetivo (ej: "ARS")
         * - consulta: Objeto para obtener tasas de cambio
         * - scanner: Para leer la cantidad del usuario
         * ==============================================
         */

        // Paso 1: Pedir la cantidad a convertir
        System.out.println("\nIngrese la Cantidad en: " + monedaOrigen + " que desea convertir a " + monedaDestino + ":");
        double cantidad;
        try {
            cantidad = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            // Paso 2: Obtener la tasa o moneda  de cambio
            double tasaCambio = consulta.obtenerTasaDeCambio(monedaOrigen, monedaDestino);

            // Paso 3: Calcular el resultado
            double cantidadConvertida = cantidad * tasaCambio;

            // Paso 4: Mostrar el resultado
            System.out.printf("\nRESULTADO: %.2f %s = %.2f %s\n",
                    cantidad, monedaOrigen,
                    cantidadConvertida, monedaDestino);

        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un valor numérico válido.");
            scanner.nextLine(); // Limpiar el buffer en caso de error
        }
    }
}

