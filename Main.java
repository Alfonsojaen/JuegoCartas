import Controller.GameController;
import View.View;

public class Main {
    public static void main(String[] args) {
                int numberOfPlayers = View.getNumberOfPlayers();
                GameController.startGame(numberOfPlayers);
            }
        }

