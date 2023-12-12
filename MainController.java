import Model.Deck;
import View.View;

public class MainController {
    public static void main(String[] args) {
        // Obtener el número de jugadores utilizando el método getNumberOfPlayers() de la clase View
        int numberOfPlayers = View.getNumberOfPlayers();

        // Iniciar el juego con el número de jugadores obtenido
        Game.startGame(numberOfPlayers);
    }
}
