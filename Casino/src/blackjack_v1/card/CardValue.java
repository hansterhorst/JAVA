package blackjack_v1.card;

public class CardValue {

    private final String name;
    private final int value;


    public CardValue(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

}
