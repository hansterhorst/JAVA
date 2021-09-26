package higherLowerGame;

import player.Player;

import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame {

    private final Scanner inputScanner;
    private final int randomNumber;
    private int guessedNumber;
    private int roundCount;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        this.randomNumber = new Random().nextInt(99) + 1;
        this.roundCount = 0;
    }

    public void playGame(Player player) {

        System.out.println(randomNumber);

        System.out.println("Hello, " + player.getName() + ". Welcome to Higher Lower");

        System.out.println("Guess a number from 1 t/m 100");
        setGuessedNumber(inputScanner.nextInt());

        while (getGuessedNumber() != getRandomNumber() || getGuessedNumber() == getRandomNumber()) {
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
                roundCount += 1;
                System.out.println("Correct! " + player.getName() + ". You guessed the number in " + getRoundCount() + " rounds");
                break;
            }
        }

    }

    private void newGuess() {
        System.out.print("Make a guess to try again. ");
        setGuessedNumber(inputScanner.nextInt());
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
