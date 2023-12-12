package Controller;

import Model.Deck;
import Model.IA;
import Model.Players;
import View.View;

import java.util.Scanner;

public class GameController {

public static void Start() {
    //Mensaje de incio
    View.MensajeInicio();
    // Obtener el número de jugadores utilizando el método getNumberOfPlayers() de la clase View
    int numberOfPlayers = View.getNumberOfPlayers();
    // Iniciar el juego con el número de jugadores obtenido
    PedirNombre(numberOfPlayers);

}
    /**
     * Método para pedir los jugadores y iniciar el juego.
     *
     * @param numberOfPlayers Número de jugadores que participarán en el juego.
     */
    public static void PedirNombre(int numberOfPlayers) {
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
            System.out.println(player.showHand());

            boolean playerWantsToContinue = true; // Variable de control

            while (playerWantsToContinue) {
                System.out.println("Valor de la mano de " + player.getName() + ": " + player.calculateHandValue());

                if (player.getName().equals("IA")) {
                    // Si es la IA, que tome su decisión automáticamente
                    boolean shouldHit = IA.decideHitOrStand(player);
                    if (shouldHit) {
                        player.drawCard(deck);
                        System.out.println(player.showHand());
                    } else {
                        playerWantsToContinue = false;
                    }
                } else {
                    System.out.println(player.getName() + ", ¿deseas otra carta? (sí/no)");
                    String response = teclado.nextLine().toLowerCase();

                    if (response.equals("sí") || response.equals("si")) {
                        player.drawCard(deck);
                        System.out.println(player.showHand());
                    } else if (response.equals("no")) {
                        playerWantsToContinue = false;
                    } else {
                        System.out.println("Respuesta no válida. Por favor, responde 'sí' o 'no'.");
                    }
                }
            }
        }
        View.Resultado(players);
        teclado.close(); // Cerrar el scanner al finalizar el juego
    }
}





