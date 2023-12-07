package Test;

import Model.Card;
import Model.Deck;
import Players.Players;

import java.util.Scanner;

public class TestBlackJack {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Deck deck = new Deck();
        // Imprime todas las cartas en el mazo
        //System.out.println(deck.toString());
        deck.ShuffleDeck();
        System.out.println(deck);
        // Imprime todas las cartas en el mazo


    }
}







