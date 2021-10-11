package blackjack_v2.card;

public class CardSuit {
   
   private final char symbol;
   private final String name;
   private final String color;
   
   public CardSuit(char symbol, String name, String color) {
      this.symbol = symbol;
      this.name = name;
      this.color = color;
   }
   
   // getters
   public char getSymbol() {
      return symbol;
   }
   
   public String getName() {
      return name;
   }
   
   public String getColor() {
      return color;
   }
}
