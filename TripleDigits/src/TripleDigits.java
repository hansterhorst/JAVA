import java.util.Random;
import java.util.Scanner;

public class TripleDigits {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean isNewGame = true;

        // play new game
        while (isNewGame) {

            // how many rounds playing
            System.out.println("How many round do you want to play?");
            int howManyRoundsPlaying = scanner.nextInt();

            for (int i = 1; i <= howManyRoundsPlaying; i++) {
                System.out.println("Round: " + i + " of " + howManyRoundsPlaying);

                // generate three random number between 1 - 9
                int maxNumber = 9;
                int randomNum1 = random.nextInt(maxNumber) + 1;
                int randomNum2 = random.nextInt(maxNumber) + 1;
                int randomNum3 = random.nextInt(maxNumber) + 1;

//            System.out.println(randomNum1 + " + " + randomNum2 + " + " + randomNum3);

                // calculate the sum and product from the three random numbers
                int sum = randomNum1 + randomNum2 + randomNum3;
                int product = randomNum1 * randomNum2 * randomNum3;

                System.out.println("Guess the three numbers. There are two hints");
                System.out.println("HINT 1: The sum is " + sum);
                System.out.println("HINT 2: The product is " + product);
                System.out.println();

                // get three numbers from the user input
                System.out.println("Type three numbers between 0 - 10 separated by pressing ENTER");
                int firstInput = scanner.nextInt();
                int secondInput = scanner.nextInt();
                int thirdInput = scanner.nextInt();

                // check if the randoms numbers are equal to the user input numbers
                // boolean hasPlayerWon = randomNum1 == firstInput && randomNum2 == secondInput && randomNum3 == thirdInput;
                boolean isFirstInput = firstInput == randomNum1 || firstInput == randomNum2 || firstInput == randomNum3;
                boolean isSecondInput = secondInput == randomNum1 || secondInput == randomNum2 || secondInput == randomNum3;
                boolean isThirdInput = thirdInput == randomNum1 || thirdInput == randomNum2 || thirdInput == randomNum3;


                // give the user information if it is correct
                if (isFirstInput && isSecondInput && isThirdInput) {
                    System.out.println("Congratulations, you WON!");
                } else {
                    System.out.println("To bad, you lost. The correct number are " + randomNum1 + ", " + randomNum2 + ", " + randomNum3 + ".");
                }
            }

            System.out.println("Do you want to play this game again? type y/n");
            String playAgain = scanner.next();
            switch (playAgain) {
                case "y":
//                    isNewGame = true; // Already assigned
                    break;
                case "n":
                    isNewGame = false;
                    break;
                default:
                    System.out.println("You typed the wrong character");
                    isNewGame = false;
                    break;
            }
        }

        System.out.println("\nThank you for playing this game.");

    }
}
