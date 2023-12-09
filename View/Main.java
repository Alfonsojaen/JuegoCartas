package View;

import Model.Deck;
import Model.Players;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberOfPlayers = getNumberOfPlayers();
        startGame(numberOfPlayers);
    }

    private static int getNumberOfPlayers() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\033[34m--------------------------------------------");
        System.out.println("\033[32m         EL CASINO DE ALFONSOJAÉN      ");
        System.out.println("\033[32m         Bienvenido al Blackjack!      ");
        System.out.println("\033[34m--------------------------------------------");

        while (true) {
            try {
                System.out.println("\033[33mPor favor, ingrese el número de jugadores (Entre 1 y 4) *Si eres una persona solo, jugarás contra la IA*: ");
                int numberOfPlayers = teclado.nextInt();

                if (numberOfPlayers >= 1 && numberOfPlayers <= 4) {
                    System.out.println("\033[36m¡Genial! El juego comenzará con " + numberOfPlayers + " jugadores.");
                    teclado.nextLine(); // Consumir el salto de línea pendiente después del próximo entero
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

    private static void startGame(int numberOfPlayers) {
        Scanner teclado = new Scanner(System.in);
        Deck deck = new Deck();
        deck.ShuffleDeck();

        Players[] players = new Players[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Introduce el nombre del Jugador " + (i + 1) + ":");
            String playerName = teclado.nextLine();
            players[i] = new Players(playerName, 15); // Se define para que tenga una mano de dos cartas

        }
        for (Players player : players) {
            player.drawCard(deck);
            player.drawCard(deck);
            player.showHand();

            while (true) {
                System.out.println("Valor de la mano de " + player.getName() + ": " + player.calculateHandValue());
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
            System.out.println("\033[32m*                  "+winner+"                *");
            System.out.println("\033[32m*               CON UN VALOR DE              *");
            System.out.println("\033[33m*                      "+maxHandValue+"      *");
            System.out.println("\033[34m*--------------------------------------------*");
        } else {
            System.out.println("No hay ganador. Todos los jugadores se han pasado de 21.");
        }

        teclado.close();
    }
}
