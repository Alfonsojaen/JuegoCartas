import Controller.GameController;
import View.View;

public class Main {
    public static void main(String[] args) {
        // Obtener el número de jugadores utilizando el método getNumberOfPlayers() de la clase View
        int numberOfPlayers = View.getNumberOfPlayers();

        // Iniciar el juego con el número de jugadores obtenido
        GameController.startGame(numberOfPlayers);
    }
}
