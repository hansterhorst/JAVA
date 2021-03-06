package slotmachineGame;

import game.Game;
import player.Player;
import slotmachineGame.slotmachine.FiveRoller;
import slotmachineGame.slotmachine.HighRoller;
import slotmachineGame.slotmachine.PennyRoller;
import slotmachineGame.slotmachine.Slotmachine;

import java.util.Scanner;

public class SlotmachineGame implements Game {
   
   private final Player player;
   private final Scanner inputScanner;
   private final Slotmachine[] slotmachines;
   private Slotmachine currentSlotmachine;
   private boolean isGameRunning = true;
   
   
   public SlotmachineGame(Scanner inputScanner, String name) {
      this.inputScanner = inputScanner;
      this.player = new Player(name);
      
      this.slotmachines = new Slotmachine[]{
              new PennyRoller("Penny Slotmachine", 3, player),
              new HighRoller("High Slotmachine", 3, player),
              new FiveRoller("Five Slotmachine", 5, player)
      };
   }
   
   
   public void playGame() {
      System.out.printf("%s, let's play a Slotmachine game.\n", player.getName());
      
      whichGameToPlay();
      
      currentSlotmachine.renderIntro();
      
      playAgain();
      
      while (isGameRunning) {
         
         runningGame();
      }
      
      System.out.printf("Thank you for playing %s. You coins to play is: %d\n",
              currentSlotmachine.getGameName(), player.getCoinsToPlay());
   }
   
   
   private void runningGame() {
      boolean isTrue = true;
      
      do {
         if (player.getCoinsToPlay() > 0 || player.getCoinsToPlay() - currentSlotmachine.getRollPrice() > 0) {
            System.out.println(player.getName() + ", do you want to play again?\n" +
                    "1. Play, 2. Quit.");
            String userInput = inputScanner.nextLine();
            if (userInput.equals("1")) playAgain();
            if (userInput.equals("2")) {
               isTrue = false;
               player.setCoinsToPlay(player.getCoinsPlayerWon());
               isGameRunning = false;
            }
         } else {
            isTrue = false;
            isGameRunning = false;
            System.out.println("Sorry, " + player.getName() + ". You don't have any credit.");
         }
      } while (isTrue);
      
   }
   
   
   private void playAgain() {
      
      player.setCoinsToPlay(currentSlotmachine.getRollPrice());
      player.setCoinsPlayerWon(currentSlotmachine.roll());
      System.out.println(player.getCoinsPlayerWon());
      
      System.out.println(currentSlotmachine.render());
      
      if (currentSlotmachine.calculatePayout() > 0) {
         System.out.println("Yes WON!");
         player.setCoinsToPlay(currentSlotmachine.getRollPrice());
      } else {
         System.out.println("Shit nothing.");
      }
      
      System.out.println("You play credit is " + player.getCoinsToPlay());
      
   }
   
   
   private void whichGameToPlay() {
      boolean isTrue = true;
      do {
         System.out.printf("""
                         Which Slotmachine game do you want to play?
                          1. Penny, %s
                          2. High, %s
                          3. Five, %s
                         """,
                 slotmachines[0].renderWinningConditions(),
                 slotmachines[1].renderWinningConditions(),
                 slotmachines[2].renderWinningConditions());
         
         String input = inputScanner.next();
         
         if (input.equals("1") || input.equals("2") || input.equals("3")) {
            int index = Integer.parseInt(input) - 1;
            currentSlotmachine = slotmachines[index];
            isTrue = false;
         } else {
            System.out.printf("Wrong input %s! Try again.\n", player.getName());
         }
      } while (isTrue);
   }
}
