package Model;

import Model.Card;
import Model.Deck;

import java.util.Arrays;
import java.util.Collections;

public class Players {
        private String name;
        private Card[] hand;
        private int numCards;
        private Deck deck;

        public Players(String name, int maxHandSize) {
            this.name = name;
            this.hand = new Card[maxHandSize];
            this.numCards = 0;
            this.deck = deck;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {

    }
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

    public void drawCard(Deck deck) {
        deck.ShuffleDeck();
            Card drawnCard = deck.getCardRandom();
            if (drawnCard != null && numCards < hand.length) {
                hand[numCards] = drawnCard;
                numCards++;
            } else {
                System.out.println("No hay más cartas en el mazo o la mano está llena.");
            }
        }
        public void showHand() {
            System.out.println("Jugador/a "+name + " :");
            for (int i = 0; i < numCards; i++) {
                System.out.println(hand[i]);
            }
        }

    }