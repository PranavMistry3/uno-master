package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 * @author Pranav Mistry
 */
public class GamePile extends GroupOfCards
{
   protected ArrayList<Card> gamePile = new ArrayList<Card>();

   public void dropACard (Card cardsToAdd)
   {
      this.gamePile.add(cardsToAdd);

   }

   public Card getGamePile (int gameBus)
   {
      return this.gamePile.get(gameBus);
   }

   public int getGamePileSize ()
   {
      return this.gamePile.size();
   }
}
