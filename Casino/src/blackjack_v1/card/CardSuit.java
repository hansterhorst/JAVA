package blackjack_v1.card;

public class CardSuit {

    private final String name;
    private final String color;
    private final char symbol;


    public CardSuit(String name, char symbol, String color) {
        this.name = name;
        this.symbol = symbol;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }


    public String getColor() {
        return color;
    }
}
