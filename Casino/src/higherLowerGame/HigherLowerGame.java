package higherLowerGame;

import player.Player;

import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame {
   
   private final Scanner inputScanner;
   private final Player player;
   private int randomNumber;
   private int guessedNumber;
   private int roundCount;
   private boolean isGameRunning;
   
   public HigherLowerGame(Scanner inputScanner, Player player) {
      this.inputScanner = inputScanner;
      this.player = player;
   }
   
   public void playGame() {
      this.isGameRunning = true;
      final int COINS_TO_WIN = 10;
      final int GAME_PRICE = 1;
      
      
      System.out.println("Hello, " + player.getName() + ". Welcome to Higher Lower");
      System.out.println("If you win! The game will pay you " + COINS_TO_WIN +
              " coins minus the rounds you guessed the number.");
      System.out.println("You have " + player.getCoinsToPlay() + " coins to play with.");
      
      while (isGameRunning) {
         this.randomNumber = new Random().nextInt(99) + 1;
         this.roundCount = 0;
         
         System.out.println("Guess a number from 1 too 100");
         setGuessedNumber(inputScanner.nextInt());
         
         player.setCoinsToPlay(GAME_PRICE);
         System.out.println(randomNumber);
         
         boolean isTrue = true;
         do {
            if (getGuessedNumber() < getRandomNumber()) {
               System.out.println("That number is to low!");
               setRoundCount();
               newGuess();
            }
            if (getGuessedNumber() > getRandomNumber()) {
               System.out.println("That number is too high!");
               setRoundCount();
               newGuess();
            }
            
            if (getGuessedNumber() == getRandomNumber()) {
               // if player guessed the number in the first round, return 0 else round count
               int coinsWon = COINS_TO_WIN - (roundCount == 0 ? 0 : roundCount);
               player.setCoinsPlayerWon(coinsWon);
               System.out.println("Correct! " + player.getName() +
                       ". You guessed the number in " + getRoundCount() + " rounds");
               System.out.println("Your winning coins are " + coinsWon);
               isTrue = false;
            }
            
         } while (isTrue);
         
         playAgain();
      }
      
      System.out.println(player.getName() + ", thank you for playing. Your won " +
              player.getCoinsPlayerWon() + " coins, and your total playing coins are now " +
              player.getCoinsToPlay());
   }
   
   private void newGuess() {
      boolean isTrue = true;
      do {
         System.out.print("Make a guess to try again. ");
         String input = inputScanner.next();
         if (input.matches("[0-9]+")) {
            setGuessedNumber(Integer.parseInt(input));
            isTrue = false;
         } else {
            System.out.println("Wrong input! Try again.");
         }
      } while (isTrue);
   }
   
   private void playAgain() {
      
      boolean isTrue = true;
      while (isTrue) {
         
         System.out.println("do you want to play again?\n" +
                 "1 = Play, 2 = Quit.");
         String input = inputScanner.next();
         
         if (input.equals("1")) {
            isTrue = false;
         } else if (input.equals("2")) {
            player.addCoinsToPlay();
            isGameRunning = false;
            isTrue = false;
         } else {
            System.out.println("Wrong input! Try again.");
         }
         
      }
   }
   
   public int getRoundCount() {
      return roundCount;
   }
   
   public int getGuessedNumber() {
      return guessedNumber;
   }
   
   public int getRandomNumber() {
      return randomNumber;
   }
   
   
   public void setGuessedNumber(int guessedNumber) {
      this.guessedNumber = guessedNumber;
   }
   
   public void setRoundCount() {
      this.roundCount += 1;
   }
   
   
}
