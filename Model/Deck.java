package Model;

import java.util.*;

public class Deck {
    // Array de palos de cartas
    private String[] suit = new String[]{"♠", "♥", "♦", "♣"};

    // Arrays para todas las cartas, las disponibles y las usadas
    private Card[] cards = new Card[52];
    private Card[] availableCards = new Card[52];
    private Card[] usedCards = new Card[52];

    // Constructor para inicializar el mazo con las 52 cartas
    public Deck() {
        int num = 0;
        // Generación de las 52 cartas con sus respectivos palos
        for (int i = 0; i < suit.length; i++) {
            for (int j = 1; j <= 13; j++) {
                cards[num] = new Card(j, suit[i]);
                availableCards[num] = cards[num]; // Todas las cartas disponibles al inicio
                num++;
            }
        }
    }

    // Método para obtener una representación de las cartas en el mazo
    @Override
    public String toString() {
        // Se crea una cadena para representar las cartas disponibles
        StringBuilder cardsString = new StringBuilder();
        for (Card card : availableCards) {
            cardsString.append(card != null ? card.toString() : "");
        }
        return cardsString.toString();
    }

    // Método para obtener una carta aleatoria del mazo
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

    // Método para barajar (shuffle) el mazo
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