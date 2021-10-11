package blackjack_v2.hand;

import blackjack_v2.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
   
   private final List<Card> hand;
   
   public Hand() {
      this.hand = new ArrayList<>();
   }
   
   public void addCard(Card card) {
      hand.add(card);
   }
   
   public int getTotalValue(){
      int total = 0;
      for (Card card : hand) {
          total += card.getValue();
      }
      return total;
   }
   
   public String render(){
      StringBuilder text = new StringBuilder();
      int index = hand.size() - 1;
      
      for (int i = 0; i < hand.size(); i++) {
         if (i == index) {
            text.append(hand.get(i).render());
         }else{
            text.append(hand.get(i).render()).append("\n");
         }
      }
      
      return text.toString();
   }
}
