package Model;

public class IA {
    private static final int IA = 17;

    public static boolean decideHitOrStand(Players player) {
        int playerTotal = player.calculateHandValue();

        if (playerTotal >= IA) {
            return false; // La IA se planta si tiene 17 o más
        }

        // La IA toma otra carta si su mano es menor o igual a 14
        return playerTotal <= 14;
    }
}