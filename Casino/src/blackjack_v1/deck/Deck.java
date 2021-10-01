package blackjack_v1.deck;

import blackjack_v1.card.Card;
import blackjack_v1.card.CardSuit;
import blackjack_v1.card.CardValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {

    private Card[] deck;
    private final CardSuit[] suits;
    private final CardValue[] values;

    public Deck(CardSuit[] suits, CardValue[] values) {
        this.suits = suits;
        this.values = values;
        this.deck = createDeck();
    }

    private Card[] createDeck() {

        List<Card> deck = new ArrayList<>();

        for (CardSuit suit : suits) {
            for (CardValue value : values) {
                Card card = new Card(suit, value);
                deck.add(card);
            }
        }

        return shuffle(deck);

    }

    private Card[] shuffle(List<Card> cards) {

        List<Card> shuffled = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cards.size(); i++) {

            int randomNum = random.nextInt(cards.size());

            shuffled.add(cards.get(randomNum));
        }

        return shuffled.toArray(new Card[0]);
    }

    public Card getNextCard() {
        Card nextCard = deck[0];

        List<Card> list = new ArrayList<>(Arrays.asList(deck));
        list.remove(0);

        deck = list.toArray(new Card[0]);

        return nextCard;
    }

    public String render() {
        StringBuilder returnValue = new StringBuilder();
        for (Card card : deck) {
            returnValue.append(card.render()).append("\n");
        }

        return returnValue.toString();
    }
}
