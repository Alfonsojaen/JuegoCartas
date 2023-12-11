package Model;

import Model.Card;
import Model.Deck;

import java.util.Arrays;
import java.util.Collections;

public class Players {

    /**
     * Nombre del jugador
     */
    private String name;

    /**
     * Mano del jugador representada como un arreglo de cartas
     */
    private Card[] hand;

    /**
     * Número de cartas actualmente en la mano del jugador
     */
    private int numCards;


    /**
     * Constructor de la clase Players.
     * @param name Nombre del jugador.
     * @param maxHandSize Tamaño máximo de la mano del jugador.
     */
    public Players(String name, int maxHandSize) {
        this.name = name;
        this.hand = new Card[maxHandSize];
        this.numCards = 0;
    }

    /**
     * Método para obtener el nombre del jugador
     */
    public String getName() {
        return name;
    }

    /**
     * Método para establecer el nombre del jugador
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método para calcular el valor total de la mano del jugador.
     * @return El valor total de las cartas en la mano del jugador.
     */
    public int calculateHandValue() {
        int handValue = 0;
        int numAces = 0;

        for (int i = 0; i < numCards; i++) {
            int cardValue = hand[i].getValue();

            if (cardValue == 1) {
                numAces++;
            } else if (cardValue >= 11 && cardValue <= 13) {
                cardValue = 10; // Asignar 10 para J, Q, K
            }

            handValue += cardValue;
        }

        while (numAces > 0 && handValue + 10 <= 21) {
            handValue += 10;
            numAces--;
        }

        return handValue;
    }

    /**
     * Método para tomar una carta del mazo y agregarla a la mano del jugador.
     * @param deck El mazo del cual se extraerá la carta.
     */
    public void drawCard(Deck deck) {
        deck.ShuffleDeck(); // Método con nombre modificado (ShuffleDeck() -> shuffleDeck())
        Card drawnCard = deck.getCardRandom();
        if (drawnCard != null && numCards < hand.length) {
            hand[numCards] = drawnCard;
            numCards++;
        } else {
            System.out.println("No hay más cartas en el mazo o la mano está llena.");
        }
    }

    /**
     * Método para mostrar las cartas en la mano del jugador
     */
    public void showHand() {
        System.out.println("Jugador/a " + name + " :");
        for (int i = 0; i < numCards; i++) {
            System.out.println(hand[i]);
        }
    }
}