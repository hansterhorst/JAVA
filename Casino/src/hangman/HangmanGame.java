package hangman;

import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
   private final static List<String> WORDS = List.of(
           "funny", "subway", "uptown", "beekeeper", "buffalo", "buzzard",
           "jackpot", "ivy", "strength", "zipper", "whiskey", "kiosk");
   private final Player player;
   private final Scanner inputScanner;
   private List<Character> guessedLetters;
   private char guessedLetter;
   private int numberOfWrongGuesses;
   private String guessingWord;
   private char[] guessingWordHidden;
   private boolean isGameRunning;
   private int COINS_TO_WIN;
   
   public HangmanGame(Scanner inputScanner, String name) {
      this.player = new Player(name);
      this.inputScanner = inputScanner;
   }
   
   private void initGame() {
      this.guessingWord = WORDS.get(new Random().nextInt(WORDS.size()));
      this.isGameRunning = true;
      this.guessingWordHidden = "•".repeat(guessingWord.length()).toCharArray();
      this.guessedLetters = new ArrayList<>();
      this.numberOfWrongGuesses = 0;
      this.COINS_TO_WIN = 10;
      final int GAME_PRICE = 1;
      player.setCoinsToPlay(GAME_PRICE);
   }
   
   
   public void playGame() {
      System.out.println(player.getName() + ", let's play the Hangman game.");
      
      initGame();
      
      while (isGameRunning) {
         try {
            playerInput();
            checkGuess();
         } catch (DuplicateLetterException error) {
            System.out.println(error.getMessage());
         }
      }
      
      
   }
   
   
   private void checkGuess() {
      
      if (findLetterInWord()) {
         System.out.printf("Correct! The letter %s is used.\n", guessedLetter);
      } else {
         System.out.printf("Wrong! The letter %s is not used.\n", guessedLetter);
      }
      renderImage();
      
      if (numberOfWrongGuesses >= ImageFactory.IMAGES.size() - 1) {
         System.out.printf("You lost! the guessed word was %s.\n", guessingWord);
         playAgain();
      }
      
      if (guessingWord.equals(new String(guessingWordHidden))) {
         System.out.printf("You won! the guessed word was %s.\n", guessingWord);
         System.out.println("Your winning credit is " + player.getCoinsPlayerWon() + " coins.");
         player.setCoinsPlayerWon(COINS_TO_WIN);
         playAgain();
      }
   }
   
   
   private void playAgain() {
      
      boolean isTrue = true;
      while (isTrue) {
         
         System.out.println(player.getName() + ", do you want to play again?\n" + " 1 = Play, 2 = Quit.");
         String input = inputScanner.next();
         
         switch (input) {
            case "1" -> {
               initGame();
               isTrue = false;
            }
            case "2" -> {
               player.addCoinsToPlay();
               System.out.println(player.getName() + ", thank you for playing. Your won " +
                       player.getCoinsPlayerWon() + " coins, and your total playing coins are now " +
                       player.getCoinsToPlay());
               isTrue = false;
               isGameRunning = false;
            }
            default -> System.out.println("Wrong input? Try again.");
         }
      }
   }
   
   
   private void playerInput() {
      boolean isTrue = true;
      while (isTrue) {
         System.out.println("Guess a letter in the word.");
         System.out.println(guessingWordHidden);
         String inputLetter = inputScanner.next();
         
         if (inputLetter.length() > 1) {
            System.out.println("Sorry, not more then one letter. Try again.");
         }
         if (guessedLetters.contains(inputLetter.charAt(0))) {
            throw new DuplicateLetterException(inputLetter.charAt(0));
         } else {
            this.guessedLetter = inputLetter.charAt(0);
            this.guessedLetters.add(guessedLetter);
            isTrue = false;
         }
      }
   }
   
   
   private boolean findLetterInWord() {
      String letter = Character.toString(guessedLetter);
      if (guessingWord.contains(letter)) {
         for (int i = 0; i < guessingWord.length(); i++) {
            if (guessingWord.charAt(i) == guessedLetter) {
               guessingWordHidden[i] = guessedLetter;
            }
         }
         return true;
      }
      numberOfWrongGuesses += 1;
      return false;
   }
   
   
   public void renderImage() {
      List<String> images = ImageFactory.getIMAGES(numberOfWrongGuesses);
      for (String image : images) {
         System.out.println(image);
      }
      System.out.println(guessingWordHidden);
   }
}
