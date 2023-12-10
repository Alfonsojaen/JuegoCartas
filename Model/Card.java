package Model;

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
        String stringValue ="";
        switch (value) {
            case 1:
                stringValue = "As";
                break;
            case 11:
                stringValue = "J";
                break;
            case 12:
                stringValue = "Q";
                break;
            case 13:
                stringValue = "K";
                break;
            default:
                stringValue = String.valueOf(value);
        }
        //String suitSymbol = "";

        // Asignar el símbolo del palo correspondiente
        //switch (suit) {
            //case "Corazones":
           //     suitSymbol = "♥";
            //    break;
           // case "Diamantes":
           //     suitSymbol = "♦";
            //    break;
        // case "Treboles":
        //    suitSymbol = "♣";
        //    break;
        //  case "Picas":
        //     suitSymbol = "♠";
        //    break;

        // }


            return ("┌─────────────┐") +
                    "\n" +
                    "│             │" +
                    "\n" +
                    "│     " + stringValue + "      │" +
                    "\n" +
                    "│             │" +
                    "\n" +
                    "│      " +suit+//suitSymbol + "      │" +
                    "\n" +
                    "│             │" +
                    "\n" +
                    "│      " + stringValue + "      │" +
                    "\n" +
                    "└─────────────┘" +
                    "\n"
                    ;


    }
}



