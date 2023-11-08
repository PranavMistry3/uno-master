package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 *
 * @author Pranav Mistry
 */
public class Card
{
   //default modifier for child classes
   private Cards cards;
   private Color color;


   public Card (Cards cards, Color color)
   {
      this.cards = cards;
      this.color = color;
   }

   public Cards getCardNumber ()
   {
      return this.cards;
   }

   public Color getCardColor ()
   {
      return this.color;
   }

   public void setCardColor (Color color)
   {
      this.color = color;
   }

}
