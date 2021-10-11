package blackjack_v2.player;

import blackjack_v2.card.Card;
import blackjack_v2.deck.Deck;
import blackjack_v2.hand.Hand;

public class Player {
   
   private final String name;
   private final Hand hand;
   private boolean isStaying;
   
   public Player(String name) {
      this.name = name;
      this.hand = new Hand();
      this.isStaying = false;
   }
   
   public String getName() {
      return name;
   }
   
   public void performNextMove(Deck deck, String move) {
      System.out.println("Perform next move. " + move);
   
      /* stay */
      if (move.equals("1")) {
         isStaying = true;
         System.out.println(name + ", you are Staying!\n");
      }
   
      /* hit */
      if (move.equals("2")) {
         addCardToHand(deck.getNextCard());
         System.out.println(renderHand());
      }
   }
   
   public void performNextMove(Deck deck) {
      addCardToHand(deck.getNextCard());
      System.out.println(renderHand());
   }
   
   public void addCardToHand(Card card) {
      hand.addCard(card);
   }
   
   public int getHandValue() {
      return hand.getTotalValue();
   }
   
   public boolean isStaying() {
      return isStaying;
   }
   
   public boolean isBust() {
      return getHandValue() > 21;
   }
   
   public String renderHand() {
      return name + ", your cards are:\n" + hand.render();
   }
   
   public boolean hasBlackjack() {
      return getHandValue() == 21;
   }
}
