package slotmachineGame.slotmachine;

import slotmachineGame.player.Player;
import slotmachineGame.reel.Symbol;

public class HighRoller extends Slotmachine {
   
   public HighRoller(String name, int numberOfReels, Player player) {
      super(name, numberOfReels, player);
   }
   
   @Override
   public int getRollPrice() {
      return 10;
   }
   
   @Override
   public int calculatePayout() {
      if (reelDeck.allReelsHaveSymbol(Symbol.HEART)) return 35;
      if (reelDeck.allReelsHaveSymbol(Symbol.CHERRIES)) return 40;
      if (reelDeck.allReelsHaveSymbol(Symbol.CLOVER)) return 45;
      if (reelDeck.allReelsHaveSymbol(Symbol.BELL)) return 50;
      return 0;
   }
   
   @Override
   public String renderWinningConditions() {
      return "is with " + super.numberOfReels + " rollers. " +
              "3x " + Symbol.HEART.icon + " 35 points." +
              "3x " + Symbol.CHERRIES.icon + " 40 points." +
              "3x " + Symbol.CLOVER.icon + " 45 points." +
              "3x " + Symbol.BELL.icon + " 50 points.";
      
   }
}
