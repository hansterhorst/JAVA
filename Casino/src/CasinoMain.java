//import blackjack_v1.BlackjackGame;
//import player.Player;

//import blackjack_v2.blackjack.Blackjack;
//import blackjack_v2.blackjack.LowBlackjack;
//import blackjack_v2.blackjack.SimpleBlackjack;
//import blackjack_v2.deck.LowDeck;
//import blackjack_v2.deck.SimpleDeck;

//import slotmachineGame.SlotmachineGame;

import hangman.HangmanGame;

import java.util.Scanner;

public class CasinoMain {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Welcome to Casino Royal!\n");
        System.out.print("What's your name? ");
        String name = inputScanner.nextLine();

//        Player player = new Player(name);

//        HigherLowerGame higherLowerGame = new HigherLowerGame(inputScanner);
//        higherLowerGame.playGame(player);

//        BlackjackGame blackjackGame = new BlackjackGame(inputScanner, player);
//        blackjackGame.playGame();
    
//        boolean isTrue = true;
//        do {
//            System.out.println(name +
//                    ", which Blackjack game do you want to play?\n" +
//                    "1 = Low Blackjack, you will play with cards from two too six.\n" +
//                    "2 = normal Blackjack.");
//            String input = inputScanner.nextLine();
//
//            if (input.equals("1")) {
//                Blackjack lowBlackjack = new LowBlackjack(inputScanner, name, new LowDeck());
//                lowBlackjack.playGame();
//                isTrue = false;
//            } else if (input.equals("2")) {
//                Blackjack blackjack = new SimpleBlackjack(inputScanner, name, new SimpleDeck());
//                blackjack.playGame();
//                isTrue = false;
//            } else {
//                System.out.println("Wrong input! Try again.");
//            }
//        } while (isTrue);
    
//        SlotmachineGame game = new SlotmachineGame(inputScanner, name);
//        game.playGame();
    
        HangmanGame game = new HangmanGame(name, inputScanner);
        game.playGame();
    }
}
