/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.Scanner;
/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author BingChen Sun
 */
public class Player
{

   private String name; //the unique name for this player

   /**
    * A constructor that allows you to set the player's unique ID
    *
    * @param name the unique ID to assign to this player.
    */

   /**
    * @return the player name
    */
   public String getPlayerName ()
   {
      return name;
   }

   /**
    * Ensure that the playerID is unique
    *
    * @param name the player name to set
    */
   public void setPlayerName ()
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter your name to get started: ");
      this.name = input.nextLine();
   }


}
