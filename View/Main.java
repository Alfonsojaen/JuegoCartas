package View;

import Model.Deck;
import Players.Players;

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
            players[i] = new Players(playerName, 2); // Se define para que tenga una mano de dos cartas
        }

        for (Players player : players) {
            while (true) {
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

        teclado.close();
    }
}
