package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 * @author Pranav Mistry
 */
public class UserHand extends GroupOfCards
{
   protected ArrayList<Card> userHand = new ArrayList<Card>();
//   int rn = (int) Math.random() * 2;

   public void addUserCards (Card cardsToAdd)
   {
      this.userHand.add(cardsToAdd);
//      super.cards.remove(0);
   }

   public Card getUserCards (int bus2)
   {
      return this.userHand.get(bus2);
   }

   public int getUserSize ()
   {
      return this.userHand.size();
   }

}
