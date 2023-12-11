package View;

import Controller.GameController;
import Model.Players;
import com.sun.jdi.Value;

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
        public static void Inicio() {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\033[34m--------------------------------------------");
            System.out.println("\033[32m         EL CASINO DE ALFONSOJAÉN      ");
            System.out.println("\033[32m         Bienvenido al Blackjack!      ");
            System.out.println("\033[34m--------------------------------------------");
        }

        /**
         * Método para obtener el número de jugadores para el juego.
         * @return El número de jugadores ingresado por el usuario.
         */
        public static int getNumberOfPlayers() {
            Scanner teclado = new Scanner(System.in);
            View.Inicio();
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