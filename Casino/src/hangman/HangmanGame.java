package hangman;

import java.util.*;

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
   
   public HangmanGame(String name, Scanner inputScanner) {
      this.player = new Player(name);
      this.inputScanner = inputScanner;
   }
   
   
   public void playGame() {
      this.guessingWord = WORDS.get(new Random().nextInt(WORDS.size()));
      this.guessingWordHidden = "•".repeat(guessingWord.length()).toCharArray();
      this.guessedLetters = new ArrayList<>();
      this.numberOfWrongGuesses = 0;
      
      System.out.println(player.getName() + ", let's play the Hangman game.");
      
      this.isGameRunning = true;
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
      String message;
      
      if (findLetterInWord()) {
         message = String.format("Correct! The letter %s is used", guessedLetter);
      } else {
         message = String.format("Wrong! The letter %s is not used", guessedLetter);
      }
      
      if (numberOfWrongGuesses > 6) {
         message = String.format("You lost! the guessed word was %s", guessingWord);
         isGameRunning = false;
      }
      
      if (guessingWord.equals(new String(guessingWordHidden))) {
         message = String.format("You won! the guessed word is %s", guessingWord);
         isGameRunning = false;
      }
      
      renderImage();
      System.out.println(message);
   }
   
   
   private void playerInput() {
      boolean isTrue = true;
      while (isTrue) {
         System.out.println("Guess a letter in the word.");
         System.out.println(guessingWordHidden);
         String inputLetter = inputScanner.nextLine();
         
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
      System.out.println(numberOfWrongGuesses);
      System.out.println(guessingWordHidden);
   }
}
