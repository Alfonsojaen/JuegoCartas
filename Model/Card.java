package Model;

import View.View;

import java.util.Objects;

public class Card {
    /**
     * Atributos privados para el valor y el palo de la carta ç
     */
    private int value;
    private String suit;

    /**
     * Constructor que inicializa una carta con un valor y un palo dados
     */
    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Constructor por defecto que inicializa una carta con valores predeterminados
     */
    public Card() {
        this(-1, "");
    }

    /**
     * Método para obtener el valor de la carta
     */
    public int getValue() {
        return value;
    }

    /**
     * Sobrescritura del método equals para comparar cartas basadas en valor y palo
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && Objects.equals(suit, card.suit);
    }

    /**
     * Sobrescritura del método toString para generar una representación visual de la carta
     * @return Genera la representación visual de la carta
     */
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
                "└─────────────┘\n");
    }
}