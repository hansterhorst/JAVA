import blackjack_v2.blackjack.LowBlackjack;
import blackjack_v2.blackjack.SimpleBlackjack;
import blackjack_v2.deck.LowDeck;
import blackjack_v2.deck.SimpleDeck;
import game.Game;
import hangman.HangmanGame;
import higherLowerGame.HigherLowerGame;
import player.Player;
import slotmachineGame.SlotmachineGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Casino {
   
   private final Scanner inputScanner;
   private Player player;
   private List<Game> games;
   
   public Casino(Scanner inputScanner) {
      this.inputScanner = inputScanner;
      this.games = new ArrayList<>();
   }
   
   public void start() {
      boolean isPlayerPlayGame = true;
      
      System.out.print("""
              Welcome to ♠️♥️ Casino Royal ♦️♣️
              What is your name?
              """);
      
      String name = inputScanner.nextLine();
      this.player = new Player(name);
      
      while (isPlayerPlayGame) {
         
         if (player.getCoinsToPlay() >= 50) {
            
            
            System.out.println(player.getName() + ", do you want play a Casino Royal game?\n" +
                    "p = Play, q = Quit");
            String gameInput = inputScanner.next();
            
            switch (gameInput) {
               case "p" -> playAGame();
               case "q" -> isPlayerPlayGame = false;
               default -> System.out.println("Wrong input! Try again.");
            }
         } else {
            System.out.println("Sorry, not enough coins to play with.");
            isPlayerPlayGame = false;
         }
      }
      
      System.out.printf("Thank for playing at Casino Royal. You won %d coins"
              , player.getCoinsToPlay());
   }
   
   private void playAGame() {
      System.out.printf("%s, you will start with %d coins. Which game do you want to play?\n"
              , player.getName(), player.getCoinsToPlay());
      System.out.print("""
               1. Higher Lower, guess a number from 1 too 100.
               2. Low Blackjack, play with a low deck of cards.
               3. Blackjack, normal blackjack.
               4. Slotmachine, play three different games.
               5. Hangman, guess a word.
              """);
      String gameNumber = inputScanner.next();
      
      games.add(new HigherLowerGame(inputScanner, player));
      games.add(new LowBlackjack(inputScanner, player.getName(), new LowDeck()));
      games.add(new SimpleBlackjack(inputScanner, player.getName(), new SimpleDeck()));
      games.add(new SlotmachineGame(inputScanner, player.getName()));
      games.add(new HangmanGame(inputScanner, player.getName()));
      
      int index = whichGameInput(gameNumber) - 1;
      games.get(index).playGame();
   }
   
   private int whichGameInput(String gameNumber) {
      do {
         if (gameNumber.matches("[1-5]")) {
            return Integer.parseInt(gameNumber);
         } else {
            System.out.println("Wrong input! Try again.");
         }
      } while (true);
   }
}
