package slotmachineGame.reel;

import java.util.List;

public class ReelDeck {
   
   private final List<Reel> reels;
   
   public ReelDeck(List<Reel> reels) {
      this.reels = reels;
   }
   
   public void roll() {
      for (Reel reel : reels) {
         reel.roll();
      }
   }
   
   public String render() {
      StringBuilder renderText = new StringBuilder();
      for (Reel reel : reels) {
         renderText.append("—").append(reel.render()).append("—");
      }
      return renderText.toString();
   }
   
   public boolean allReelsHaveSymbol(Symbol symbol){
      
      for (Reel reel : reels) {
          if (!reel.getSymbol().equals(symbol)){
             return false;
          }
      }
      return true;
   }
   
}
