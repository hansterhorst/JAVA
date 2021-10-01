package blackjack_v1;

import blackjack_v1.card.CardSuit;
import blackjack_v1.card.CardValue;
import blackjack_v1.deck.Deck;
import blackjack_v1.gamePlayer.GamePlayer;
import player.Player;

import java.util.Scanner;

public class BlackjackGame {

    private final Scanner inputScanner;
    private final GamePlayer player;
    private final GamePlayer dealer;
    private GamePlayer currentPlayer;
    private final Deck deck;


    public BlackjackGame(Scanner inputScanner, Player player) {
        this.inputScanner = inputScanner;
        this.player = new GamePlayer(player);
        this.dealer = new GamePlayer(new Player("Dealer"));
        this.currentPlayer = this.player;
        this.deck = new Deck(suits(), values());
    }

    public void playGame() {
        
        System.out.println("Welcome " + player.getName() + ". Let's play Blackjack!");
        
        if (currentPlayer.equals(player)) {

            currentPlayer.addCardToHand(deck);
            currentPlayer.addCardToHand(deck);
            System.out.println(currentPlayer.renderHand());


            boolean isTrue = true;
            do {

                if (currentPlayer.equals(player)) {
                    String printMessage = " do you want another card? \n 1 = Hit, 2 = Stay.";
                    System.out.println(currentPlayer.getName() + printMessage);
                }

                String inputValue = inputScanner.nextLine();

                    switch (inputValue) {
                        /*  Hit */
                        case "1" -> {
                            currentPlayer.performMove(deck, currentPlayer);
                            if (currentPlayer.isBust(currentPlayer)) {
                                System.out.println(currentPlayer.getName() + " you are Busted!");
                                switchGamePlayer(currentPlayer);
                                isTrue = false;
                            }
                        }
                        /*  Stay */
                        case "2" -> {
                            switchGamePlayer(currentPlayer);
                            currentPlayer.addCardToHand(deck);
                            currentPlayer.performMove(deck, currentPlayer);
                            isTrue = false;
                        }
                        default -> System.out.println("Wrong input! Try again.");
                    }

            } while (isTrue);
        }

        if (!player.isBust(player)) {
            if (player.getHandValue() > dealer.getHandValue() || dealer.isBust(dealer)) {
                if(dealer.isBust(dealer)){
                    System.out.println(dealer.getName() + " you are Busted!");
                }
                System.out.println(player.getName() + " has won Blackjack!");
            } else if (dealer.getHandValue() == player.getHandValue()) {
                System.out.println(dealer.getName() + " has won Blackjack!");
            } else {
                System.out.println(dealer.getName() + " has won Blackjack!");
            }

        } else {
            System.out.println(dealer.getName() + " has won Blackjack!");
        }

    }

    private void switchGamePlayer(GamePlayer currentPlayer) {

        this.currentPlayer = currentPlayer.equals(player) ? dealer : player;

    }

    private CardSuit[] suits() {
        return new CardSuit[]{
                new CardSuit("Diamonds", '♢', "red"),
                new CardSuit("Hearts", '♡', "red"),
                new CardSuit("Spades", '♤', "black"),
                new CardSuit("Clubs", '♧', "black")
        };
    }

    private CardValue[] values() {
        return new CardValue[]{
                new CardValue("Ace", 1),
                new CardValue("Two", 2),
                new CardValue("Three", 3),
                new CardValue("Four", 4),
                new CardValue("Five", 5),
                new CardValue("Six", 6),
                new CardValue("Seven", 7),
                new CardValue("Eight", 8),
                new CardValue("Nine", 9),
                new CardValue("Ten", 10),
                new CardValue("Jack", 10),
                new CardValue("Queen", 10),
                new CardValue("King", 10)
        };
    }

}
