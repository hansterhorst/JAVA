package slotmachineGame.slotmachine;

import player.Player;
import slotmachineGame.reel.Reel;
import slotmachineGame.reel.ReelDeck;

import java.util.ArrayList;
import java.util.List;

public abstract class Slotmachine {
   
   protected final String slotmachineName;
   protected final int numberOfReels;
   protected ReelDeck reelDeck;
   protected Player player;
   
   public Slotmachine(String slotmachineName, int numberOfReels, Player player) {
      this.slotmachineName = slotmachineName;
      this.player = player;
      this.numberOfReels = numberOfReels;
      
      List<Reel> reels = new ArrayList<>();
      for (int i = 0; i < numberOfReels; i++) {
         reels.add(new Reel());
      }
      this.reelDeck = new ReelDeck(reels);
      
   }
   
   public String getGameName() {
      return slotmachineName;
   }
   
   public int roll() {
      reelDeck.roll();
      return calculatePayout();
   }
   
   public String render() {
      return reelDeck.render();
   }
   
   public void renderIntro() {
      System.out.println(player.getName()+", let's play " + slotmachineName + ".");
      System.out.println("Your credit is "+ player.getCoinsToPlay());
   }
   
   public abstract int getRollPrice();
   
   public abstract int calculatePayout();
   
   public abstract String renderWinningConditions();
}
