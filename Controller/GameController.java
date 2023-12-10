package Controller;

import Model.Deck;
import Model.IA;
import Model.Players;

import java.util.Scanner;

public class GameController {

    public static int getNumberOfPlayers() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\033[34m--------------------------------------------");
        System.out.println("\033[32m         EL CASINO DE ALFONSOJAÉN      ");
        System.out.println("\033[32m         Bienvenido al Blackjack!      ");
        System.out.println("\033[34m--------------------------------------------");

        while (true) {
            try {
                System.out.println("\033[33mPor favor, ingrese el número de jugadores (Entre 1 y 4) *Si eres una persona sola, jugarás contra la IA*: ");
                int numberOfPlayers = teclado.nextInt();

                if (numberOfPlayers >= 1 && numberOfPlayers <= 4) {
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

    public static void startGame(int numberOfPlayers) {
        Scanner teclado = new Scanner(System.in);
        Deck deck = new Deck();
        deck.ShuffleDeck();

        Players[] players;

        if (numberOfPlayers == 1) {
            players = new Players[2];
            System.out.println("Introduce tu nombre:");
            String playerName = teclado.nextLine();
            players[0] = new Players(playerName, 15);
            players[1] = new Players("IA", 15); // Nombre predeterminado para la IA
        } else {
            players = new Players[numberOfPlayers]; // Si hay más de un jugador, creamos el array normalmente
            for (int i = 0; i < numberOfPlayers; i++) {
                System.out.println("Introduce el nombre del Jugador " + (i + 1) + ":");
                String playerName = teclado.nextLine();
                players[i] = new Players(playerName, 15);
            }
        }

        playGame(teclado, deck, players);
    }

    public static void playGame(Scanner teclado, Deck deck, Players[] players) {
        for (Players player : players) {
            player.drawCard(deck);
            player.drawCard(deck);
            player.showHand();

            while (true) {
                System.out.println("Valor de la mano de " + player.getName() + ": " + player.calculateHandValue());

                if (player.getName().equals("IA")) {
                    // Si es la IA, que tome su decisión automáticamente
                    boolean shouldHit = IA.decideHitOrStand(player);
                    if (shouldHit) {
                        player.drawCard(deck);
                        player.showHand();
                    } else {
                        break;
                    }
                } else {
                    System.out.println(player.getName() + ", ¿deseas otra carta? (sí/no)");
                    String response = teclado.nextLine().toLowerCase();

                    if (response.equals("sí") || response.equals("si")) {
                        player.drawCard(deck);
                        player.showHand();
                    } else if (response.equals("no")) {
                        break;
                    } else {
                        System.out.println("Respuesta no válida. Por favor, responde 'sí' o 'no'.");

                    }
                }
            }
        }
            int maxHandValue = 0;
            String winner = "";

            for (Players player : players) {
                int handValue = player.calculateHandValue();

                if (handValue <= 21 && handValue > maxHandValue) {
                    maxHandValue = handValue;
                    winner = player.getName();
                }
            }

            if (!winner.isEmpty()) {
                System.out.println("\033[34m*--------------------------------------------*");
                System.out.println("\033[32m*         EL GANADOR DEL BLACKJACK ES:       *");
                System.out.println("\033[32m*                  " + winner + "                *");
                System.out.println("\033[32m*               CON UN VALOR DE              *");
                System.out.println("\033[33m*                      " + maxHandValue + "      *");
                System.out.println("\033[34m*--------------------------------------------*");
            } else {
                System.out.println("No hay ganador. Todos los jugadores se han pasado de 21.");
            }

            teclado.close();
        }
    }

