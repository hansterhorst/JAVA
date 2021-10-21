import higherLowerGame.HigherLowerGame;
import player.Player;

import java.util.Scanner;

public class CasinoMain {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Welcome to Casino Royal!\n");
        System.out.print("What's your name? ");
        String name = inputScanner.nextLine();
        Player player = new Player(name);
    
        HigherLowerGame game = new HigherLowerGame(inputScanner, player);
        game.playGame();

    }
}
