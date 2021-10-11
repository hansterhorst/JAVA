package blackjack_v2.card;

public class CardValue {
   
   private final String name;
   private final int value;
   
   public CardValue(String name, int value) {
      this.name = name;
      this.value = value;
   }
   
   public String getName() {
      return name;
   }
   
   public int getValue() {
      return value;
   }
}
