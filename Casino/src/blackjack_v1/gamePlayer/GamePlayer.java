package blackjack_v1.gamePlayer;

import blackjack_v1.card.Card;
import blackjack_v1.deck.Deck;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer extends Player {

    private Card[] cardsInHand;
    private int handValue;
    private boolean isBust;
    private boolean isStaying;


    public GamePlayer(Player player) {
        super(player.getName());
        this.cardsInHand = new Card[]{};
        this.handValue = 0;
        this.isBust = false;
        this.isStaying = false;
    }


    public void performMove(Deck deck, GamePlayer player) {

        if (player.getName().equals("Dealer")) {
            while (player.getHandValue() < 17) {

                addCardToHand(deck);
            }
        } else {
            addCardToHand(deck);
        }

        System.out.println(renderHand());

    }

    public void addCardToHand(Deck deck) {

        List<Card> cards = new ArrayList<>(List.of(cardsInHand));
        cards.add(deck.getNextCard());
        cardsInHand = cards.toArray(new Card[0]);

        setHandValue();

    }


    public void isStaying(GamePlayer player) {

        if (player.getName().equals("Dealer")) {
            if (player.handValue < 17) {
                this.isStaying = false;
            }
        } else {
            this.isStaying = true;
        }
    }


    public boolean getIsStaying() {
        return isStaying;
    }

    public boolean isBust(GamePlayer player) {

        return player.getHandValue() > 21;
    }


    public int getHandValue() {
        return handValue;
    }

    private void setHandValue() {
        int cardValues = 0;
        for (Card card : cardsInHand) {
            cardValues += card.getValue();
        }
        this.handValue = cardValues;
    }


    public String renderHand() {
        StringBuilder string = new StringBuilder("\n" + super.getName() + " cards in hand: \n");
        for (Card card : cardsInHand) {
            string.append(card.render()).append("\n");
        }
        string.append("Your hand value is: ").append(getHandValue()).append("\n");
        return string.toString();
    }
}
