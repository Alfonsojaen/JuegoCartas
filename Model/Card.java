package Model;

import View.View;

import java.util.Objects;

public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public Card() {

        this(-1, "");
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuit() {

        return suit;
    }

    public void setSuit(String suit) {

        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && Objects.equals(suit, card.suit);
    }

    @Override
    public String toString() {
        String stringValue = View.obtenerValorCarta(value);

        return ("┌─────────────┐\n" +
                "│             │\n" +
                "│   " + stringValue + "        │\n" +
                "│             │\n" +
                "│      " + suit + "      │\n" +
                "│             │\n" +
                "│        " + stringValue + "   │\n" +
                "│             │\n" +
                "└─────────────┘");
    }
}



