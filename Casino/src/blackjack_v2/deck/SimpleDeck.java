package blackjack_v2.deck;

import blackjack_v2.card.Card;
import blackjack_v2.card.CardSuit;
import blackjack_v2.card.CardValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleDeck extends Deck {
   
   List<Card> simpleDeck;
   private int deckIndex;
   
   public SimpleDeck() {
      this.deckIndex = 0;
      this.simpleDeck = new ArrayList<>();
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
              new CardValue("Seven", 7),
              new CardValue("Eight", 8),
              new CardValue("Nine", 9),
              new CardValue("Ten", 10),
              new CardValue("Jack", 10),
              new CardValue("Queen", 10),
              new CardValue("King", 10),
      };
      
      for (CardSuit suit : suits) {
         for (CardValue value : values) {
            simpleDeck.add(new Card(suit, value));
         }
      }
   
   }
   
   @Override
   public void shuffle() {
      List<Card> shuffledList = new ArrayList<>();
      Random random = new Random();
      for (int i = simpleDeck.size(); i > 0; i--) {
         int randomIndex = random.nextInt(simpleDeck.size());
         shuffledList.add(simpleDeck.get(randomIndex));
         simpleDeck.remove(randomIndex);
      }

      simpleDeck = shuffledList;
   }
   
   @Override
   public boolean isEmpty() {
      return simpleDeck.size() == deckIndex;
   }
   
   @Override
   public Card getNextCard() {
      deckIndex += 1;
      return simpleDeck.get(deckIndex);
   }
   
   @Override
   public int getDeckSize() {
      return simpleDeck.size();
   }
   
   
   @Override
   public void resetDeckIndex(){
      this.deckIndex = 0;
   }
}
