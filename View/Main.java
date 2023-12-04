package View;

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
                System.out.println("\033[33mPor favor, ingrese el número de jugadores ( Entre 1 y 4) *Si eres una persona solo, juagaras contra la IA*: ");
                int numberOfPlayers = teclado.nextInt();

                if (numberOfPlayers >= 1 && numberOfPlayers <= 4) {
                    System.out.println("\033[36m¡Genial! El juego comenzará con " + numberOfPlayers + " jugadores.");
                    teclado.close();
                    return numberOfPlayers;
                } else {
                    System.out.println("\033[31mLo siento, pero el número de jugadores debe estar entre 1 y 4. Por favor, ingrese nuevamente: ");
                }
            } catch (Exception e) {
                System.out.println("\033[31mLo siento, pero su entrada no es un número válido. Por favor, ingrese nuevamente: ");
                teclado.next(); // Descartar la entrada errónea
            }
        }
    }

    private static void startGame(int numberOfPlayers) {
    }
}

