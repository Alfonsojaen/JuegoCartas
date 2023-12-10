import Controller.GameController;

public class Main {
    public static void main(String[] args) {
                int numberOfPlayers = GameController.getNumberOfPlayers();
                GameController.startGame(numberOfPlayers);
            }
        }

