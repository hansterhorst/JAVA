package blackjack_v2.blackjack;

import blackjack_v2.deck.Deck;

import java.util.Scanner;

public class SimpleBlackjack extends Blackjack {
   
   private final Scanner scanner;
   private final Deck deck;
   private final int COINS_TO_WIN;
   
   public SimpleBlackjack(Scanner scanner, String name, Deck simpleDeck) {
      super(scanner, name, simpleDeck, 20);
      this.scanner = scanner;
      this.deck = simpleDeck;
      this.COINS_TO_WIN = 40;
   }
   
   @Override
   protected void runGameLoop() {
      if (currentPlayer.equals(player)) {
         
         if (!player.isStaying() || !player.isBust()) {
            userInput();
         }
         
         if (player.isBust()) {
            System.out.println(player.getName() + ", you're BUSTED!");
            System.out.println(dealer.getName() + ", you WON!");
            isPlaying = false;
         }
         
         if (player.hasBlackjack()) {
            System.out.println(player.getName() + ", BLACKJACK you WON!");
            player.setCoinsPlayerWon(COINS_TO_WIN);
            isPlaying = false;
         }
         
      } else {
         
         if (!dealer.isStaying()) {
            dealer.performNextMove(deck);
            System.out.println(dealer.renderHand());
            System.out.println("Your hand total is: " + dealer.getHandValue() + "\n");
         }
         
         if (dealer.isBust()) {
            System.out.println("Dealer, you're BUSTED!");
            System.out.println(player.getName() + ", you WON!");
            player.setCoinsPlayerWon(COINS_TO_WIN);
            isPlaying = false;
         }
         
         if (dealer.getHandValue() == player.getHandValue()) {
            System.out.println(dealer.getName() + ", you WON!");
            System.out.println(player.getName() + ", you LOST!");
            isPlaying = false;
         }
         
         if (dealer.isStaying() && dealer.getHandValue() > player.getHandValue()) {
            System.out.println(dealer.getName() + ", you WON!");
            System.out.println(player.getName() + ", you LOST!");
            isPlaying = false;
         }
         
         if (dealer.hasBlackjack()) {
            System.out.println(dealer.getName() + ", BLACKJACK you WON!");
            isPlaying = false;
         }
         
      }
      
   }
   
   private void userInput() {
      boolean isTrue = true;
      
      while (isTrue) {
         
         System.out.println(player.getName() + ", what is your next move?\n 1 = Stay, 2 = Hit");
         String move = scanner.next();
         
         switch (move) {
            case "1" -> { // stay
               currentPlayer = dealer;
               isTrue = false;
            }
            case "2" -> { // hit
               player.performNextMove(deck, move);
               System.out.println("Your hand total is: " + player.getHandValue() + "\n");
               isTrue = false;
            }
            default -> System.out.println("Wrong input!. Try again.");
         }
      }
   }
}
