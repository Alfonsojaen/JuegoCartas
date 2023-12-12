import Model.Deck;
import Model.IA;
import Model.Players;

import java.util.Scanner;

public class Game {
    /**
     * Método para iniciar el juego.
     *
     * @param numberOfPlayers Número de jugadores que participarán en el juego.
     */
    public static void startGame(int numberOfPlayers) {
        Scanner teclado = new Scanner(System.in);
        Deck deck = new Deck();
        deck.ShuffleDeck();

        Players[] players;

        // Configuración de los jugadores según el número de jugadores ingresado
        if (numberOfPlayers == 1) {
            // Creación de jugadores en caso de un solo jugador
            players = new Players[2];
            System.out.println("Introduce tu nombre:");
            // Validación del nombre del jugador humano
            // Si el nombre contiene números o la palabra 'IA', solicita otro nombre
            String playerName = "";
            boolean validName = false;

            while (!validName) {
                try {
                    playerName = teclado.nextLine();
                    if (playerName.matches(".*\\d+.*") ||  playerName.toUpperCase().contains("IA") || playerName.contains(" ")) {
                        throw new IllegalArgumentException("El nombre no puede contener números, la palabra 'IA' o espacios. Introduce otro nombre:");
                    }
                    validName = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            players[0] = new Players(playerName, 20); // Jugador humano
            players[1] = new Players("IA", 20); // Jugador IA
        } else {
            // Creación de jugadores en caso de múltiples jugadores
            players = new Players[numberOfPlayers];
            for (int i = 0; i < numberOfPlayers; i++) {
                System.out.println("Introduce el nombre del Jugador " + (i + 1) + ":");
                // Validación de los nombres de los jugadores
                String playerName = "";
                boolean validName = false;

                while (!validName) {
                    try {
                        playerName = teclado.nextLine();
                        if (playerName.matches(".*\\d+.*") || playerName.toUpperCase().contains("IA")) {
                            throw new IllegalArgumentException("El nombre no puede contener números ni la palabra 'IA'. Introduce otro nombre:");
                        }
                        validName = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                players[i] = new Players(playerName, 20);
            }
        }

        playGame(teclado, deck, players);
    }

    /**
     * Método principal para ejecutar el juego.
     *
     * @param teclado Scanner para la entrada del usuario.
     * @param deck    Mazo de cartas utilizado en el juego.
     * @param players Arreglo de jugadores que participan en el juego.
     */
    public static void playGame(Scanner teclado, Deck deck, Players[] players) {
        // Lógica del juego para cada jugador
        for (Players player : players) {
            player.drawCard(deck);
            player.drawCard(deck);
            player.showHand();

            boolean playerWantsToContinue = true; // Variable de control

            while (playerWantsToContinue) {
                System.out.println("Valor de la mano de " + player.getName() + ": " + player.calculateHandValue());

                if (player.getName().equals("IA")) {
                    // Si es la IA, que tome su decisión automáticamente
                    boolean shouldHit = IA.decideHitOrStand(player);
                    if (shouldHit) {
                        player.drawCard(deck);
                        player.showHand();
                    } else {
                        playerWantsToContinue = false;
                    }
                } else {
                    System.out.println(player.getName() + ", ¿deseas otra carta? (sí/no)");
                    String response = teclado.nextLine().toLowerCase();

                    if (response.equals("sí") || response.equals("si")) {
                        player.drawCard(deck);
                        player.showHand();
                    } else if (response.equals("no")) {
                        playerWantsToContinue = false;
                    } else {
                        System.out.println("Respuesta no válida. Por favor, responde 'sí' o 'no'.");
                    }
                }
            }
        }

        // Determinar al ganador y mostrar el resultado
        int maxHandValue = 0;
        String winner = "";
        boolean isDraw = false;

        for (Players player : players) {
            int handValue = player.calculateHandValue();

            if (handValue <= 21 && handValue > maxHandValue) {
                maxHandValue = handValue;
                winner = player.getName();
                isDraw = false;
            } else if (handValue <= 21 && handValue == maxHandValue) {
                isDraw = true;
            }
        }

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

        teclado.close(); // Cerrar el scanner al finalizar el juego
    }
}
