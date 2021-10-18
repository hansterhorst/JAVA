package slotmachineGame.reel;

public enum Symbol {
   
   HEART("❤️"), BELL("🔔"), CHERRIES("🍒"), CLOVER("🍀");
   
   public final String icon;
   
   Symbol(String icon) {
      this.icon = icon;
   }
   
}
