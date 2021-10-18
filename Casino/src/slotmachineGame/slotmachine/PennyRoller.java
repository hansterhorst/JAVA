package slotmachineGame.slotmachine;

import slotmachineGame.player.Player;
import slotmachineGame.reel.Symbol;

public class PennyRoller extends Slotmachine {
   
   public PennyRoller(String name, int numberOfReels, Player player) {
      super(name, numberOfReels, player);
   }
   
   @Override
   public int getRollPrice() {
      return 1;
   }
   
   @Override
   public int calculatePayout() {
      if (reelDeck.allReelsHaveSymbol(Symbol.HEART)) return 5;
      if (reelDeck.allReelsHaveSymbol(Symbol.CHERRIES)) return 10;
      if (reelDeck.allReelsHaveSymbol(Symbol.CLOVER)) return 15;
      if (reelDeck.allReelsHaveSymbol(Symbol.BELL)) return 20;
      return 0;
   }
   
   @Override
   public String renderWinningConditions() {
      return "is with " + super.numberOfReels + " rollers. " +
              "3x " + Symbol.HEART.icon + " 5 points. " +
              "3x " + Symbol.CHERRIES.icon + " 10 points. " +
              "3x " + Symbol.CLOVER.icon + " 15 points. " +
              "3x " + Symbol.BELL.icon + " 20 points.";
   }
}
