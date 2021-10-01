import blackjack_v1.BlackjackGame;
import player.Player;

import java.util.Scanner;

public class CasinoMain {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Welcome to Casino Royal!\n");
        System.out.print("What's your name? ");
        String name = inputScanner.nextLine();

        Player player = new Player(name);

//        HigherLowerGame higherLowerGame = new HigherLowerGame(inputScanner);
//        higherLowerGame.playGame(player);

        BlackjackGame blackjackGame = new BlackjackGame(inputScanner, player);
        blackjackGame.playGame();


    }
}
