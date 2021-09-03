import higherLowerGame.HigherLowerGame;

import java.util.Scanner;

public class CasinoMain {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);


        HigherLowerGame higherLowerGame = new HigherLowerGame(inputScanner);
        higherLowerGame.playGame();

    }
}
