package blackjack_v2.blackjack;

import blackjack_v2.deck.Deck;
import blackjack_v2.player.BlackjackPlayer;

import java.util.Scanner;

public abstract class Blackjack {
   
   private final Scanner scanner;
   private final Deck deck;
   protected final BlackjackPlayer player;
   protected final BlackjackPlayer dealer;
   protected BlackjackPlayer currentPlayer;
   protected boolean isPlaying;
   protected boolean isGameRunning;
   private final int priceToPlay;
   
   public Blackjack(Scanner scanner, String name, Deck deck, int priceToPlay ) {
      this.scanner = scanner;
      this.deck = deck;
      this.player = new BlackjackPlayer(name);
      this.dealer = new BlackjackPlayer("Dealer");
      this.currentPlayer = this.player;
      this.isPlaying = true;
      this.isGameRunning = true;
      this.priceToPlay = priceToPlay;
   }
   
   public void playGame() {
      
      
      String gameName = deck.getDeckSize() == 20 ? " Low Blackjack!" : " Blackjack!";
      System.out.println(player.getName() + ", let's play" + gameName + "\n");
   
      while (isGameRunning) {
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
         
         playAgain();
      }
      System.out.println("Winning coins " + player.getCoinsPlayerWon() + ". Coins to play " + player.getCoinsToPlay());
      
   }
   
   private void playAgain() {
      player.setCoinsToPlay(priceToPlay);
      boolean isTrue = true;
      do {
         System.out.println("Do you want to play again?\n" + "1 = Play, 2 = Quit");
         String input = scanner.next();
         if (input.equals("1")) {
            resetGame();
            isTrue = false;
            isPlaying = true;
         } else if (input.equals("2")) {
            player.addCoinsToPlay();
            isGameRunning = false;
            isTrue = false;
         } else {
            System.out.println("Wrong input! Try again.");
         }
      } while (isTrue);
   }
   
   private void resetGame(){
      player.resetPlayer();
      dealer.resetPlayer();
      currentPlayer = player;
      deck.resetDeckIndex();
   }
   
   protected abstract void runGameLoop();
}
