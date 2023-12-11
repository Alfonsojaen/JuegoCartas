package View;

import Controller.GameController;
import Model.Players;
import com.sun.jdi.Value;

import java.util.Scanner;
public class View {
            public static String obtenerValorCarta(int value) {
                String stringValue = "";

                if (value == 1) {
                    stringValue = "A ";
                } else if (value == 11) {
                    stringValue = "J ";
                } else if (value == 12) {
                    stringValue = "Q ";
                } else if (value == 13) {
                    stringValue = "K ";
                } else {
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

    public static void Incio() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\033[34m--------------------------------------------");
        System.out.println("\033[32m         EL CASINO DE ALFONSOJAÉN      ");
        System.out.println("\033[32m         Bienvenido al Blackjack!      ");
        System.out.println("\033[34m--------------------------------------------");
    }
    public static int getNumberOfPlayers() {
        Scanner teclado = new Scanner(System.in);
        View.Incio();
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
}
