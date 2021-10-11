package blackjack_v2.blackjack;

import blackjack_v2.deck.Deck;
import blackjack_v2.player.Player;

import java.util.Scanner;

public abstract class Blackjack {
   
   private final Scanner scanner;
   private final Deck deck;
   protected final Player player;
   protected final Player dealer;
   protected Player currentPlayer;
   protected boolean isPlaying;
   
   public Blackjack(Scanner scanner, String name, Deck deck) {
      this.scanner = scanner;
      this.deck = deck;
      this.player = new Player(name);
      this.dealer = new Player("Dealer");
      this.currentPlayer = player;
      this.isPlaying = true;
   }
   
   public void playGame() {
      String gameName = deck.getDeckSize() == 20 ? " Low Blackjack!" : " Blackjack!";
      System.out.println(player.getName() + ", let's play" + gameName + "\n");
      deck.shuffle();
      player.addCardToHand(deck.getNextCard());
      player.addCardToHand(deck.getNextCard());
      
      dealer.addCardToHand(deck.getNextCard());
      System.out.println(dealer.renderHand());
      System.out.println("Your hand value is " + dealer.getHandValue() + "\n");
      
      System.out.println(player.renderHand());
      System.out.println("Your hand value is " + player.getHandValue() + "\n");
      
      while (isPlaying && !deck.isEmpty()) {
         
         runGameLoop();
         
      }
   }
   
   public String getName() {
      return currentPlayer.getName();
   }
   
   protected abstract void runGameLoop();
}
