package Model;

public class IA {
    private static final int IA = 18;

    /**
     * Método para que la IA decida si pedir otra carta (hit) o plantarse (stand).
     * @param player El jugador (en este caso, la IA) para evaluar su mano.
     * @return true si la IA decide pedir otra carta, false si se planta.
     */
    public static boolean decideHitOrStand(Players player) {
        // Calcular el valor total de la mano del jugador (IA)
        int playerTotal = player.calculateHandValue();

        // La IA se planta si tiene 18 o más
        if (playerTotal >= IA) {
            return false;
        }

        // La IA toma otra carta si su mano es menor o igual a 14
        return playerTotal <= 14;
    }
}