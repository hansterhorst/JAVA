package higherLowerGame;

import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame {

    private Scanner inputScanner;
    private int randomNumber;
    private int guessedNumber;
    private int roundCount;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        this.randomNumber = new Random().nextInt(99) + 1;
        this.roundCount = 0;
    }

    public void playGame() {
        System.out.println("Welcome to Casino Royal!\n");
        System.out.println(randomNumber);

        System.out.println("What is your name");
        String name = inputScanner.nextLine();
        System.out.println("Hello, " + name + ". Welcome to Higher Lower");

        System.out.println("Guess a number from 1 t/m 100");
        guessedNumber = inputScanner.nextInt();
        System.out.println(guessedNumber);

        while (guessedNumber != randomNumber) {
            if (guessedNumber < randomNumber) {
                System.out.println("That number is to low!");
                roundCount += 1;
                newGuess();
            }

            if (guessedNumber > randomNumber) {
                System.out.println("That number is too high!");
                roundCount += 1;
                newGuess();
            }

            if (guessedNumber == randomNumber) {
                roundCount += 1;
                System.out.println("Correct! " + name + ". You guessed the number in " + roundCount + " rounds");
                break;
            }
        }

    }

    public void newGuess() {
        System.out.println("Make a guess to try again.");
        guessedNumber = inputScanner.nextInt();
    }
}
