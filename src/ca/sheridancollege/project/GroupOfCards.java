package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A concrete class that represents any grouping of cards for a Game.
 *
 * @author Pranav Mistry
 */
public class GroupOfCards
{

   //The group of cards, stored in an ArrayList
   protected ArrayList<Card> cards = new ArrayList<Card>();
//   private int size;//the size of the grouping

//   public GroupOfCards ()
//   {
////      this.size = size;
//   }

//   public void addCards (Cards card)
//   {
//      this.cards.add(card);
//   }
   public void addCards (Card card)
   {
      this.cards.add(card);
//      this.cards.add(Cards.TWO);
//      this.cards.add(Cards.THREE);
//      this.cards.add(Cards.FOUR);
   }

   /**
    * A method that will get the group of cards as an ArrayList
    *
    * @return the group of cards.
    */
   public Card getCards (int bus)
   {
//      if (this.cards.isEmpty()) {
//         throw new Exception("No cards here.");
//      }
//      for (int i = 0; i < this.getSize() - 1; i++) {
//
//      }
      return this.cards.get(bus);

   }

   /**
    * @return the size of the group of cards
    */
   public int getSize ()
   {
      return this.cards.size();
   }

   /**
    * @param size the max size for the group of cards
    */
//   public void setSize (int size)
//   {
//      this.size = size;
//   }

}//end class
