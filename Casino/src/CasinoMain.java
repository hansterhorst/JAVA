import blackjack_v2.blackjack.Blackjack;
//import blackjack_v2.blackjack.LowBlackjack;
//import blackjack_v2.deck.LowDeck;
import blackjack_v2.blackjack.SimpleBlackjack;
import blackjack_v2.deck.SimpleDeck;
//import higherLowerGame.HigherLowerGame;
import player.Player;
import slotmachineGame.SlotmachineGame;
import slotmachineGame.slotmachine.Slotmachine;

import java.util.Scanner;

public class CasinoMain {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Welcome to Casino Royal!\n");
        System.out.print("What's your name? ");
        String name = inputScanner.nextLine();
        Player player = new Player(name);
    
//        HigherLowerGame game = new HigherLowerGame(inputScanner, player);
//        game.playGame();
    
//        Blackjack game = new LowBlackjack(inputScanner, name, new LowDeck());
//        game.playGame();
        
//        Blackjack game = new SimpleBlackjack(inputScanner, name, new SimpleDeck());
//        game.playGame();
    
        SlotmachineGame game = new SlotmachineGame(inputScanner, name);
        game.playGame();

    }
}
