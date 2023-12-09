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
        this.name = name;
    }
    public int calculateHandValue() {
        int handValue = 0;
        for (int i = 0; i < numCards; i++) {
            handValue += hand[i].getValue();
        }
        return handValue;
    }
    public void drawCard(Deck deck) {
        deck.ShuffleDeck();
            Card drawnCard = deck.getCardRamdon();
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