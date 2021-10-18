package slotmachineGame.slotmachine;

import slotmachineGame.player.Player;
import slotmachineGame.reel.Symbol;

public class FiveRoller extends Slotmachine {
   
   public FiveRoller(String name, int numberOfReels, Player player) {
      super(name, numberOfReels, player);
   }
   
   @Override
   public int getRollPrice() {
      return 5;
   }
   
   @Override
   public int calculatePayout() {
      if (reelDeck.allReelsHaveSymbol(Symbol.HEART)) return 15;
      if (reelDeck.allReelsHaveSymbol(Symbol.CHERRIES)) return 20;
      if (reelDeck.allReelsHaveSymbol(Symbol.CLOVER)) return 25;
      if (reelDeck.allReelsHaveSymbol(Symbol.BELL)) return 30;
      return 0;
   }
   
   @Override
   public String renderWinningConditions() {
      return "is with " + super.numberOfReels + " rollers. " +
              "3x " + Symbol.HEART.icon + " 15 points." +
              "3x " + Symbol.CHERRIES.icon + " 20 points." +
              "3x " + Symbol.CLOVER.icon + " 25 points." +
              "3x " + Symbol.BELL.icon + " 30 points.";
      
   }
}
