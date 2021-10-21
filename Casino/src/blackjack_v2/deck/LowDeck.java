package blackjack_v2.deck;

import blackjack_v2.card.Card;
import blackjack_v2.card.CardSuit;
import blackjack_v2.card.CardValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LowDeck extends Deck {
   
   private List<Card> lowDeck;
   private int deckIndex;
   
   
   public LowDeck() {
      this.deckIndex = 0;
      this.lowDeck = new ArrayList<>();
      
      CardSuit[] suits = new CardSuit[]{
              new CardSuit('♢', "Diamond", "Red"),
              new CardSuit('♤', "Spades", "Black"),
              new CardSuit('♡', "Hearts", "Red"),
              new CardSuit('♧', "Clubs", "Black"),
      };
      
      CardValue[] values = new CardValue[]{
              new CardValue("Two", 2),
              new CardValue("Three", 3),
              new CardValue("Four", 4),
              new CardValue("Five", 5),
              new CardValue("Six", 6),
      };
      
      
      for (CardSuit suit : suits) {
         for (CardValue value : values) {
            lowDeck.add(new Card(suit, value));
         }
      }
   }
   
   @Override
   public Card getNextCard() {
      deckIndex += 1;
      return lowDeck.get(deckIndex);
   }
   
   @Override
   public void shuffle() {
      Random random = new Random();
      List<Card> shuffledList = new ArrayList<>();
      
      for (int i = lowDeck.size(); i > 0; i--) {
         int randomIndex = random.nextInt(lowDeck.size());
         shuffledList.add(lowDeck.get(randomIndex));
         lowDeck.remove(randomIndex);
      }
      lowDeck = shuffledList;
   }
   
   @Override
   public boolean isEmpty() {
      return lowDeck.size() == deckIndex;
   }
   
   @Override
   public int getDeckSize() {
      return lowDeck.size();
   }
   
   
   @Override
   public void resetDeckIndex(){
      this.deckIndex = 0;
   }
}
