package blackjack_v2.deck;

import blackjack_v2.card.Card;

public abstract class Deck {
   public Deck() {
   }
   
   public abstract void shuffle();
   
   public abstract boolean isEmpty();
   
   public abstract Card getNextCard();
   
   public abstract int getDeckSize();
   
   public abstract void resetDeckIndex();
   
}
