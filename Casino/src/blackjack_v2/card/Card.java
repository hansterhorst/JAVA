package blackjack_v2.card;

public class Card {
   
   private final CardSuit suit;
   private final CardValue value;
   
   public Card(CardSuit suit, CardValue value) {
      this.suit = suit;
      this.value = value;
   }
   
   public int getValue() {
      return value.getValue();
   }
   
   public String render() {
      return "Card: " + suit.getSymbol() + " " + value.getName() + " " + getValue();
   }
}
