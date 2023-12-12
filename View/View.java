package View;

import Model.Players;

import java.util.Scanner;
public class View {
        /**
         * Método para obtener el valor de una carta en formato de texto.
         * @param value Valor numérico de la carta.
         * @return Representación en texto del valor de la carta.
         */
        public static String obtenerValorCarta(int value) {
            String stringValue = "";

            // Asignar valores específicos para As, Jotas, Reinas y Reyes; otros valores numéricos se mantienen
            if (value == 1) {
                stringValue = "A ";
            } else if (value == 11) {
                stringValue = "J ";
            } else if (value == 12) {
                stringValue = "Q ";
            } else if (value == 13) {
                stringValue = "K ";
            } else {
                // Para el resto de los valores, asegurar que se muestren correctamente
                if (value == 10) {
                    stringValue = "10";
                } else if (value < 10) {
                    stringValue = value + " ";
                } else {
                    stringValue = String.valueOf(value);
                }
            }

            return stringValue;
        }

        /**
         * Método para imprimir el mensaje de inicio del juego.
         */
        public static void MensajeInicio() {
            System.out.println("\033[31m--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\033[32m--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\033[34m######## ##           ######     ###     ######  #### ##    ##  #######     ########  ########       ###    ##       ########  #######  ##    ##  ######   #######");
            System.out.println("##       ##          ##    ##   ## ##   ##    ##  ##  ###   ## ##     ##    ##     ## ##            ## ##   ##       ##       ##     ## ###   ## ##    ## ##     ##");
            System.out.println("##       ##          ##        ##   ##  ##        ##  ####  ## ##     ##    ##     ## ##           ##   ##  ##       ##       ##     ## ####  ## ##       ##     ##");
            System.out.println("######   ##          ##       ##     ##  ######   ##  ## ## ## ##     ##    ##     ## ######      ##     ## ##       ######   ##     ## ## ## ##  ######  ##     ##");
            System.out.println("##       ##          ##       #########       ##  ##  ##  #### ##     ##    ##     ## ##          ######### ##       ##       ##     ## ##  ####       ## ##     ##");
            System.out.println("##       ##          ##    ## ##     ## ##    ##  ##  ##   ### ##     ##    ##     ## ##          ##     ## ##       ##       ##     ## ##   ### ##    ## ##     ##");
            System.out.println("######## ########     ######  ##     ##  ######  #### ##    ##  #######     ########  ########    ##     ## ######## ##        #######  ##    ##  ######   #######");
            System.out.println("\033[32m--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\033[31m--------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        }

        /**
         * Método para obtener el número de jugadores para el juego.
         * @return El número de jugadores ingresado por el usuario.
         */
        public static int getNumberOfPlayers() {
            Scanner teclado = new Scanner(System.in);
            while (true) {
                try {
                    System.out.println("\033[33m Blackjack! Por favor, ingrese el número de jugadores (Entre 1 y 4) *Si eres una persona sola, jugarás contra la IA*: ");
                    int numberOfPlayers = teclado.nextInt();

                    if (numberOfPlayers == 1) {
                        System.out.println("\033[36m¡Genial! El juego comenzará con un jugador.");
                        teclado.nextLine();
                        return 1; // Si el jugador ingresa 1, se establece el número de jugadores a 1 (jugador humano solamente)
                    } else if (numberOfPlayers >= 2 && numberOfPlayers <= 4) {
                        System.out.println("\033[36m¡Genial! El juego comenzará con " + numberOfPlayers + " jugadores.");
                        teclado.nextLine();
                        return numberOfPlayers;
                    } else {
                        System.out.println("\033[31mLo siento, pero el número de jugadores debe estar entre 1 y 4. Por favor, ingrese nuevamente: ");
                    }
                } catch (Exception e) {
                    System.out.println("\033[31mLo siento, pero su entrada no es un número válido. Por favor, ingrese nuevamente: ");
                    teclado.nextLine(); // Limpiar el buffer del scanner
                }
            }
        }


    public static void Resultado (Players[] players){
        // Determinar al ganador y mostrar el resultado

        // Variables para almacenar la mano más alta, el ganador y si hay empate
        int maxHandValue = 0;
        String winner = "";
        boolean isDraw = false;

        // Iterar a través de los jugadores para determinar la mano más alta y al posible ganador
        for (Players player : players) {
            int handValue = player.calculateHandValue();

            // Verificar si la mano del jugador está por debajo o igual a 21 y es más alta que la mano máxima actual
            if (handValue <= 21 && handValue > maxHandValue) {
                maxHandValue = handValue;
                winner = player.getName();
                isDraw = false;
            } else if (handValue <= 21 && handValue == maxHandValue) {
                isDraw = true;
            }
        }

        // Contar la cantidad de jugadores con la misma mano más alta para determinar si hay un empate total
        int countWinners = 0;
        for (Players player : players) {
            int handValue = player.calculateHandValue();
            if (handValue == maxHandValue) {
                countWinners++;
            }
        }

        if (countWinners == players.length && isDraw) {
            System.out.println("¡Es un empate! Todos los jugadores tienen la misma puntuación.");
        } else if (!winner.isEmpty() && !isDraw) {
            // Mostrar al ganador y el valor de su mano
            System.out.println("\033[34m*--------------------------------------------");
            System.out.println("\033[32m*         EL GANADOR DEL BLACKJACK ES:       ");
            System.out.println("\033[33m*                    " + winner + "                ");
            System.out.println("\033[32m*               CON UN VALOR DE              ");
            System.out.println("\033[33m*                      " + maxHandValue + "      ");
            System.out.println("\033[34m*--------------------------------------------");
        } else {
            System.out.println("No hay un claro ganador. Todos los jugadores se han pasado de 21 o tienen la misma puntuación.");
        }

    }
    }
