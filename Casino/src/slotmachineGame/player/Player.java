package slotmachineGame.player;

public class Player {
   
   private final String name;
   private int credit;
   private int payout;
   
   public Player(String name) {
      this.name = name;
      this.credit = 100;
      this.payout = 0;
   }
   
   
   public String getName() {
      return name;
   }
   
   public int getCredit() {
      return credit;
   }
   
   public int getPayout() {
      return credit;
   }
   
   public void setCredit(int coin, int price) {
      this.credit -= coin;
      if (price > 0) this.credit += price;
   }
   
   public void setPayout() {
      this.payout = credit;
   }
   
   public String renderPlayerConditions() {
      return "Your credit is " + credit + ".";
   }
}
