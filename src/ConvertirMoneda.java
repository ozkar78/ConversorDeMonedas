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
        System.out.println("\nIngrese la Cantidad en " + monedaOrigen + " que desea convertir a " + monedaDestino + ":");

        while (true) {  // Bucle para reintentos en caso de error
            try {
                // Paso 1.1: Leer entrada como texto y estandarizar formato (acepta "," o ".")
                String input = scanner.nextLine().trim().replace(",", ".");

                // Paso 1.2: Convertir a número
                double cantidad = Double.parseDouble(input);

                // Paso 2: Obtener la tasa de cambio desde la API
                double tasaCambio = consulta.obtenerTasaDeCambio(monedaOrigen, monedaDestino);

                // Paso 3: Calcular el resultado
                double cantidadConvertida = cantidad * tasaCambio;

                // Paso 4: Mostrar el resultado formateado
                System.out.printf("\nRESULTADO: %.2f %s = %.2f %s\n",
                        cantidad, monedaOrigen,
                        cantidadConvertida, monedaDestino);
                break;  // Salir del bucle si todo fue exitoso

            } catch (NumberFormatException e) {
                // Paso 5: Manejar error de formato numérico
                System.out.println("\n❌ Error: Debe ingresar un valor numérico válido (ej: 100, 50.25 o 75,50).");
                System.out.print("Por favor, intente nuevamente: ");
            } catch (Exception e) {
                // Paso 6: Manejar otros errores inesperados (ej: fallo en la API)
                System.out.println("\n⚠️ Error inesperado: " + e.getMessage());
                System.out.print("Por favor, intente nuevamente: ");
            }
        }
    }
}