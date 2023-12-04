package Test;

import Model.Card;
import Model.Deck;

public class TestBlackJack {
    public static void main(String[] args) {
         Card card = new Card();
          System.out.println(card);
          Deck deck = new Deck();

        // Imprime todas las cartas en el mazo
        for (int i = 0; i < 52; i++) {
         System.out.println(deck.getCard());

        }

    }

}
