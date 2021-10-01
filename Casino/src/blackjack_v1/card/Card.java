package blackjack_v1.card;

public class Card {

    private final CardSuit suit;
    private final CardValue value;


    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }


    public String render() {
        return "Card: " + suit.getSymbol() + " " + getValue();
    }


    public int getValue() {
        return value.getValue();
    }
}
