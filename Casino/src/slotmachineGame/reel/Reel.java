package slotmachineGame.reel;

import java.util.Random;

public class Reel {
   
   private Symbol symbol;
   private final Symbol[] symbols;
   
   public Reel() {
      this.symbols = Symbol.values();
      roll();
   }
   
   public void roll(){
      Random random = new Random();
      int index = random.nextInt(symbols.length);
      this.symbol = symbols[index];
   }
   
   public String render(){
      return getSymbol().icon;
   }
   
   public Symbol getSymbol(){
      return symbol;
   }
}
