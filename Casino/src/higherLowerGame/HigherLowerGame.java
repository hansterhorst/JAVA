package higherLowerGame;

import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame {

    private Scanner inputScanner;
    private int randomNumber;
    private int guessedNumber;
    private int roundCount;
    private String name;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        this.randomNumber = new Random().nextInt(99) + 1;
        this.roundCount = 0;
    }

    public void playGame() {
        System.out.println("Welcome to Casino Royal!\n");
        System.out.println(randomNumber);

        System.out.println("What is your name");
        setName(inputScanner.nextLine());
        System.out.println("Hello, " + getName() + ". Welcome to Higher Lower");

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
                System.out.println("Correct! " + getName() + ". You guessed the number in " + getRoundCount() + " rounds");
                break;
            }
        }

    }

    /* methodes */
    private void newGuess() {
        System.out.println("Make a guess to try again.");
        setGuessedNumber(inputScanner.nextInt());
    }

    /* getters & setters */
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getGuessedNumber(){
        return guessedNumber;
    }
    public void setGuessedNumber(int guessedNumber){
        this.guessedNumber = guessedNumber;
    }

    public  int getRoundCount(){
        return roundCount;
    }
    public void setRoundCount(){
        this.roundCount +=1;
    }

    public  int getRandomNumber(){
        return randomNumber;
    }

}
