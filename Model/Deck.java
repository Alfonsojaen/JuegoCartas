package Model;

import java.util.*;

public class Deck {
    private String[] suit = new String[]{"♠", "♥", "♦", "♣"};
    private Card[] cards = new Card[52];
    private Card[] availableCards = new Card[52];
    private Card[] usedCards = new Card[52];

    public Deck() {
        int num = 0;
        for (int i = 0; i < suit.length; i++) {
            for (int j = 1; j <= 13; j++) {
                cards[num] = new Card(j, suit[i]);
                availableCards[num] = cards[num];
                num++;
            }
        }
    }

    @Override
    public String toString() {
         Card[] availableCards = new Card[52];
        StringBuilder cardsString = new StringBuilder();
        for (Card card : availableCards) {
            cardsString.append(card != null ? card.toString() : "");
        }
        return cardsString.toString();
    }

    public Card getCardRandom() {
        int availableCount = 52;
        int usedCount = 0;
        if (availableCount == 0) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(availableCount);
        Card card = availableCards[randomIndex];
        availableCards[randomIndex] = null;
        availableCount--;
        usedCards[usedCount] = card;
        usedCount++;
        return card;
    }

    public void ShuffleDeck() {
        int availableCount = 52;
        Random random = new Random();
        for (int i = 0; i < availableCount; i++) {
            int randomIndex = i + random.nextInt(availableCount - i);
            Card temp = availableCards[randomIndex];
            availableCards[randomIndex] = availableCards[i];
            availableCards[i] = temp;
        }
    }
}