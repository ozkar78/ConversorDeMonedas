import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        /*
         * ==============================================
         * PROGRAMA: CONVERSOR DE MONEDAS
         * FUNCIONALIDAD: Convierte valores entre diferentes divisas
         * USO: Seleccione una opción del menú e ingrese el valor a convertir
         * ==============================================
         */

        // ==================== INICIALIZACIÓN ====================
        /*
         * PASO 1: Preparar los datos necesarios:
         * - Scanner: Para leer entrada del usuario
         * - ConsultarMoneda: Clase que obtiene divisas de cambio (debería conectarse a una API)
         */
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        int opcion = 0; // Controla la opción seleccionada

        // ==================== MENÚ PRINCIPAL ====================
        /*
         * PASO 2: Mostrar el menú para que el  usuario elija una opcion
         * PASO 2.1: Utilizar IA para mejora el diseño y la interfaz visual

         */
        while (opcion != 8) {
            System.out.println("\n🌟**********************************************🌟");
            System.out.println("🎉 ¡BIENVENIDO AL CONVERSOR DE MONEDAS! 💸🌍");
            System.out.println("Selecciona una opción para comenzar tu viaje financiero 🚀:");
            System.out.println("1️⃣  USD 🇺🇸 → ARS 🇦🇷  (Dólar a Peso Argentino)");
            System.out.println("2️⃣  ARS 🇦🇷 → USD 🇺🇸  (Peso Argentino a Dólar)");
            System.out.println("3️⃣  USD 🇺🇸 → BRL 🇧🇷  (Dólar a Real Brasileño)");
            System.out.println("4️⃣  BRL 🇧🇷 → USD 🇺🇸  (Real Brasileño a Dólar)");
            System.out.println("5️⃣  USD 🇺🇸 → CLP 🇨🇱  (Dólar a Peso Chileno)");
            System.out.println("6️⃣  CLP 🇨🇱 → USD 🇺🇸  (Peso Chileno a Dólar)");
            System.out.println("7️⃣  🔄 Conversión personalizada (¡elige cualquier moneda!)");
            System.out.println("8️⃣  ❌ Salir del conversor (¡hasta la próxima!)");
            System.out.println("🌟**********************************************🌟");

            try {
                // ==================== ENTRADA USUARIO ====================
                /*
                 * PASO 3: Leemos la opción del usuario
                 * Usamos try-catch para manejar errores si ingresa texto en vez de número
                 */
                opcion = Integer.parseInt(lectura.nextLine());

                // ==================== PROCESAMIENTO ====================
                /*
                 * PASO 4: Según la opción seleccionada:
                 * - Opciones 1-6: Conversiones predefinidas
                 * - Opción 7: Conversión libre entre cualquier par de monedas
                 * - Opción 8: Finaliza el programa
                 */
                switch (opcion) {
                    case 1:
                        System.out.println("\nCONVIRTIENDO DÓLARES A PESOS ARGENTINOS");
                        /*
                         * PASO 4.1: Convertir USD a ARS segun codigo API
                         */
                        ConvertirMoneda.convertir("USD", "ARS", consulta, lectura);
                        break;

                    case 2:
                        System.out.println("\nCONVIRTIENDO PESOS ARGENTINOS A DÓLARES");
                        ConvertirMoneda.convertir("ARS", "USD", consulta, lectura);
                        break;

                    case 3:
                        System.out.println("\nCONVIRTIENDO DÓLARES A REALES BRASILEÑOS");
                        ConvertirMoneda.convertir("USD", "BRL", consulta, lectura);
                        break;

                    case 4:
                        System.out.println("\nCONVIRTIENDO REALES BRASILEÑOS A DÓLARES");
                        ConvertirMoneda.convertir("BRL", "USD", consulta, lectura);
                        break;

                    case 5:
                        System.out.println("\nCONVIRTIENDO DÓLARES A PESOS CHILENOS");
                        ConvertirMoneda.convertir("USD", "CLP", consulta, lectura);
                        break;

                    case 6:
                        System.out.println("\nCONVIRTIENDO PESOS CHILENOS A DÓLARES");
                        ConvertirMoneda.convertir("CLP", "USD", consulta, lectura);
                        break;

                    case 7:
                        /*
                         * PASO 4.2: Conversión personalizada
                         * El usuario ingresa los códigos ISO de las monedas
                         */
                        System.out.println("\nCONVERSIÓN PERSONALIZADA");
                        System.out.println("Ingrese código de moneda origen (ej: USD, EUR):");
                        String origen = lectura.nextLine().toUpperCase();
                        System.out.println("Ingrese código de moneda destino:");
                        String destino = lectura.nextLine().toUpperCase();
                        ConvertirMoneda.convertir(origen, destino, consulta, lectura);
                        break;

                    case 8:
                        System.out.println("\n👋 ¡Gracias por usar el conversor de monedas, crack financiero! 💸🌍");
                        System.out.println("✨ Recuerda: el conocimiento es la mejor inversión. ¡Hasta la próxima!");
                        break;

                    default:
                        System.out.println("\n❌ Opción inválida... 😅");
                        System.out.println("📣 Por favor, ingresa un número del 1 al 8 y vuelve a intentarlo. ¡Tú puedes!");
                        break;

                }

            } catch (NumberFormatException e) {
                /*
                 * PASO 5: Manejo de  excepciones y/o errores que se puedan presentar
                 * Si el usuario ingresa texto en vez de número
                 */
                System.out.println("\nERROR: Debe ingresar un número (1-8)");
            }
        }

        // ==================== FINALIZACIÓN ====================
        /*
         * PASO 6: Cerramos el Scanner para liberar recursos
         */
        lectura.close();
    }
}