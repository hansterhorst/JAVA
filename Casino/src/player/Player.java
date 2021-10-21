package player;

public class Player {

    private String name;
    private int coinsToPlay;
    private int coinsPlayerWon;

    public Player(String name) {
        this.name = name;
        this.coinsToPlay = 1000;
        this.coinsPlayerWon = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    public int getCoinsToPlay() {
        return coinsToPlay;
    }
    public void setCoinsToPlay(int gamePrice) {
        this.coinsToPlay -= gamePrice;
    }
    
    
    public int getCoinsPlayerWon() {
        return coinsPlayerWon;
    }
    public void setCoinsPlayerWon(int coinsPlayerWon) {
        this.coinsPlayerWon += coinsPlayerWon;
    }
    
    
    public void addCoinsToPlay() {
        this.coinsToPlay += coinsPlayerWon;
    }
}
