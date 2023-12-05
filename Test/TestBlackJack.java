package Test;

import Model.Card;
import Model.Deck;

public class TestBlackJack {
    public static void main(String[] args) {
        Deck deck = new Deck();
        // Imprime todas las cartas en el mazo
        //System.out.println(deck.toString());
        deck.ShuffleDeck();
        System.out.println(deck);
        // Imprime todas las cartas en el mazo


        }

    }


