package Model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Deck {
    private String[] suit = new String[]{"Picas", "Corazones", "Diamantes", "Trevoles"};
    private Card[] cards = new Card[52];

    // Constructor
    public Deck() {
        int num = 0;
        for (int i = 0; i < suit.length; i++) {
            for (int j = 1; j <= 13; j++) {
                cards[num++] = new Card(j, suit[i]);
            }
        }

    }

    @Override
    public String toString() {
        StringBuffer cardsString = new StringBuffer("");
        for(int i=0;i<cards.length;i++){
            cardsString.append(cards[i].toString());
        }
        return cardsString.toString();
    }
    // Coger una carta aleatoria del mazo
    public Card getCardRamdon() {
        int num = 0;
        if (num >= 52) {
                return null;
        }
        return cards[num++];
    }
    public void ShuffleDeck(){
        Collections.shuffle(Arrays.asList(cards));

    }

    // Comprueba si hay mas cartas.
    public boolean hasMoreCards() {
        int num = 0;
        return num < 52;
    }
}

