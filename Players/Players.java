package Players;

import Model.Card;
import Model.Deck;

public class Players {
        private String name;
        private Card[] hand;
        private int numCards;

        public Players(String name, int maxHandSize) {
            this.name = name;
            this.hand = new Card[maxHandSize];
            this.numCards = 0;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void drawCard(Deck deck) {
            Card drawnCard = deck.getCardRamdon();
            if (drawnCard != null && numCards < hand.length) {
                hand[numCards] = drawnCard;
                numCards++;
            } else {
                System.out.println("No hay más cartas en el mazo o la mano está llena.");
            }
        }

        public void showHand() {
            System.out.println(name + "'s hand:");
            for (int i = 0; i < numCards; i++) {
                System.out.println(hand[i]);
            }
        }

    }