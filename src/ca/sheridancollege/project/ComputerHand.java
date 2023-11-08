package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 * @author Pranav Mistry
 */
public class ComputerHand extends GroupOfCards
{
   protected ArrayList<Card> computerHand = new ArrayList<Card>();
//   int rn = (int) Math.random() * 2;

   public void addComputerCards (Card cardsToAdd)
   {
      this.computerHand.add(cardsToAdd);
//      super.cards.remove(0);
   }

   public Card getComputerCards (int bus3)
   {
      return this.computerHand.get(bus3);
   }

   public int getComputerSize ()
   {
      return this.computerHand.size();
   }

}
