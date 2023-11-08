/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Game
{

//to be activated //   protected final String name;//the title of the game
   protected Player player = new Player();
   GroupOfCards gc = new GroupOfCards();
   protected UserHand user = new UserHand();
   protected ComputerHand computer = new ComputerHand();
   protected Scanner input = new Scanner(System.in);
   protected GamePile gp = new GamePile();
   protected int userIndex;
   protected int computerIndex;
   protected boolean running = true;

   public void assignCards ()
   {
// adding enums to the GroupOfCards arraylist
      gc.addCards(new Card(Cards.ONE, Color.BLUE));
      gc.addCards(new Card(Cards.ONE, Color.RED));
      gc.addCards(new Card(Cards.ONE, Color.GREEN));
      gc.addCards(new Card(Cards.ONE, Color.YELLOW));
      gc.addCards(new Card(Cards.TWO, Color.BLUE));
      gc.addCards(new Card(Cards.TWO, Color.RED));
      gc.addCards(new Card(Cards.TWO, Color.GREEN));
      gc.addCards(new Card(Cards.TWO, Color.YELLOW));
      gc.addCards(new Card(Cards.THREE, Color.BLUE));
      gc.addCards(new Card(Cards.THREE, Color.RED));
      gc.addCards(new Card(Cards.THREE, Color.GREEN));
      gc.addCards(new Card(Cards.THREE, Color.YELLOW));
      gc.addCards(new Card(Cards.FOUR, Color.BLUE));
      gc.addCards(new Card(Cards.FOUR, Color.RED));
      gc.addCards(new Card(Cards.FOUR, Color.GREEN));
      gc.addCards(new Card(Cards.FOUR, Color.YELLOW));
      gc.addCards(new Card(Cards.FIVE, Color.BLUE));
      gc.addCards(new Card(Cards.FIVE, Color.RED));
      gc.addCards(new Card(Cards.FIVE, Color.GREEN));
      gc.addCards(new Card(Cards.FIVE, Color.YELLOW));
      gc.addCards(new Card(Cards.SIX, Color.BLUE));
      gc.addCards(new Card(Cards.SIX, Color.RED));
      gc.addCards(new Card(Cards.SIX, Color.GREEN));
      gc.addCards(new Card(Cards.SIX, Color.YELLOW));
      gc.addCards(new Card(Cards.SEVEN, Color.BLUE));
      gc.addCards(new Card(Cards.SEVEN, Color.RED));
      gc.addCards(new Card(Cards.SEVEN, Color.GREEN));
      gc.addCards(new Card(Cards.SEVEN, Color.YELLOW));
      gc.addCards(new Card(Cards.EIGHT, Color.BLUE));
      gc.addCards(new Card(Cards.EIGHT, Color.RED));
      gc.addCards(new Card(Cards.EIGHT, Color.GREEN));
      gc.addCards(new Card(Cards.EIGHT, Color.YELLOW));
      gc.addCards(new Card(Cards.NINE, Color.BLUE));
      gc.addCards(new Card(Cards.NINE, Color.RED));
      gc.addCards(new Card(Cards.NINE, Color.GREEN));
      gc.addCards(new Card(Cards.NINE, Color.YELLOW));
      gc.addCards(new Card(Cards.DRAWTWO, Color.BLUE));
      gc.addCards(new Card(Cards.DRAWTWO, Color.RED));
      gc.addCards(new Card(Cards.DRAWTWO, Color.GREEN));
      gc.addCards(new Card(Cards.DRAWTWO, Color.YELLOW));
      gc.addCards(new Card(Cards.DRAWFOUR, Color.BLACK));
      gc.addCards(new Card(Cards.WILD, Color.BLACK));
      System.out.println("--------------------------------------UNO----------------------------------------");
      //Creating the user's hand of 7 cards
      for (int i = 0; i < 7; i++) {
         int rn = (int) (Math.random() * gc.getSize());

         user.addUserCards(gc.getCards(rn));
         gc.cards.remove(rn);
      }
      //Creating the computer's hand of 7 cards
      for (int j = 0; j < 7; j++) {
         int rn2 = (int) (Math.random() * gc.getSize());

         computer.addComputerCards(gc.getCards(rn2));
         gc.cards.remove(rn2);
      }

   }

//A method for when computer picks Draw four
   public void computerDrawFour ()
   {
      if (gc.getSize() < 4) {
         System.out.println("Not enough cards left in the game pile. GamePile size = " + gc.getSize());
         running = false;
      }
      else {
         System.out.println("adding 4 cards to " + player.getPlayerName() + "'s hand");
         gp.dropACard(computer.getComputerCards(computerIndex));
         computer.computerHand.remove(computerIndex);

         for (int i = 0; i < 4; i++) {
            int rn = (int) (Math.random() * gc.getSize());


            user.addUserCards(gc.getCards(rn));
            gc.cards.remove(rn);
         }
      }
      System.out.println("Choose a color 1 RED, 2 BLUE, 3 YELLOW, 4 GREEN");
      int choice = (int) (Math.random() * 4);
      if (choice == 1) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.RED));

      }
      else if (choice == 2) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.BLUE));
      }
      else if (choice == 3) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.YELLOW));
      }
      else if (choice == 4) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.GREEN));
      }
      System.out.println("Computer chose the color: " + gp.getGamePile(gp.getGamePileSize() - 1).getCardColor());
      System.out.println("choice = " + choice);
//            }
   }

   //A method to peek the game pile
   public void showLastCardDropped ()
   {
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("Last Card Dropped: " + gp.getGamePile(gp.getGamePileSize() - 1).getCardNumber() + " " + gp.getGamePile(gp.getGamePileSize() - 1).getCardColor());
   }

   //A method for when user picks Draw four
   public void userDrawFour ()
   {
      if (gc.getSize() < 4) {
         System.out.println("Not enough cards left in the game pile. GamePile size = " + gc.getSize());
         running = false;
      }
      else {
         System.out.println("adding 4 cards to computer's hand gc size" + gc.getSize());
         gp.dropACard(user.getUserCards(userIndex));
         user.userHand.remove(userIndex);

         for (int i = 0; i < 4; i++) {
            int rn = (int) (Math.random() * gc.getSize());


            computer.addComputerCards(gc.getCards(rn));
            gc.cards.remove(rn);
         }
      }
      System.out.println("Choose a color 1 RED, 2 BLUE, 3 YELLOW, 4 GREEN");
      int choice = input.nextInt();
      if (choice == 1) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.RED));
//                  gp.getGamePile(gp.getGamePileSize()).setCardColor(Color.RED);
      }
      else if (choice == 2) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.BLUE));
      }
      else if (choice == 3) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.YELLOW));
      }
      else if (choice == 4) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.GREEN));
      }
      else {
         System.out.println("invalid input");
      }
   }

   //A method for when computer picks Draw two
   public void computerDrawTwo ()
   {
      if (gc.getSize() < 2) {
         System.out.println("Not enough cards left in the game pile. GamePile size = " + gc.getSize());
      }
      else {
         System.out.println("adding 2 cards to " + player.getPlayerName() + "'s hand");
         gp.dropACard(computer.getComputerCards(computerIndex));
         computer.computerHand.remove(computerIndex);
         for (int i = 0; i < 2; i++) {
            int rn = (int) (Math.random() * gc.getSize());


            user.addUserCards(gc.getCards(rn));
            gc.cards.remove(rn);
         }
      }
   }

   //A method for when user picks Draw two
   public void userDrawTwo ()
   {
      if (gc.getSize() < 2) {
         System.out.println("Not enough cards left in the game pile. GamePile size = " + gc.getSize());
      }
      else {
         System.out.println("adding 2 cards to computer's hand");
         gp.dropACard(user.getUserCards(userIndex));
         user.userHand.remove(userIndex);

         for (int i = 0; i < 2; i++) {
            int rn = (int) (Math.random() * gc.getSize());


            computer.addComputerCards(gc.getCards(rn));
            gc.cards.remove(rn);
         }
      }
   }

//A method for when computer picks the wild card
   public void computerWild ()
   {
      gp.dropACard(computer.getComputerCards(computerIndex));
      computer.computerHand.remove(computerIndex);
      System.out.println("Choose a color 1 RED, 2 BLUE, 3 YELLOW, 4 GREEN");
      int choice = (int) (Math.random() * 4);
      if (choice == 1) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.RED));

      }
      else if (choice == 2) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.BLUE));
      }
      else if (choice == 3) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.YELLOW));
      }
      else if (choice == 4) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.GREEN));
      }
      System.out.println("Computer chose the color: " + gp.getGamePile(gp.getGamePileSize() - 1).getCardColor());
   }

   //A method for when user picks the wild card
   public void userWild ()
   {
      gp.dropACard(user.getUserCards(userIndex));
      user.userHand.remove(userIndex);
      System.out.println("Choose a color 1 RED, 2 BLUE, 3 YELLOW, 4 GREEN");
      int choice = input.nextInt();
      if (choice == 1) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.RED));

      }
      else if (choice == 2) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.BLUE));
      }
      else if (choice == 3) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.YELLOW));
      }
      else if (choice == 4) {
         gp.dropACard(new Card(Cards.COLORCHANGE, Color.GREEN));
      }
      else {
         System.out.println("invalid input");
      }
   }

   //A method for when computer drops a card into the game pile
   public void computerDropCard ()
   {
      gp.dropACard(computer.getComputerCards(computerIndex));
      computer.computerHand.remove(computerIndex);
      System.out.println("Game Pile has: ");
      for (int gameCheck = 0; gameCheck < gp.getGamePileSize(); gameCheck++) {


         System.out.println(gp.getGamePile(gameCheck).getCardNumber() + " " + gp.getGamePile(gameCheck).getCardColor());
      }
   }

   //A method to show the user's cards
   public void showUserHand ()
   {
      System.out.println("----User's turn----");
      System.out.println("You have: ");
      System.out.println(user.getUserSize() + " Cards in your hand:");
      int counter2 = 0;
      for (int bus2 = 0; bus2 < user.getUserSize(); bus2++) {

         System.out.println(counter2 + ", " + user.getUserCards(bus2).getCardNumber() + " " + user.getUserCards(bus2).getCardColor());
         counter2++;

      }
   }

//A method for when user drops a card into the game pile
   public void userDropCard ()
   {


      gp.dropACard(user.getUserCards(userIndex));
      user.userHand.remove(userIndex);
      System.out.println(gp.getGamePile(0).getCardNumber() + " " + gp.getGamePile(0).getCardColor());
      System.out.println("Game Pile has: ");
      for (int gameCheck = 0; gameCheck < gp.getGamePileSize(); gameCheck++) {


         System.out.println(gp.getGamePile(gameCheck).getCardNumber() + " " + gp.getGamePile(gameCheck).getCardColor());
      }
   }





   /**
    * a method to Play the game. overridden in the GamePlay class
    */
   public abstract void play ();

   /**
    * When the game is over, this method would declare and display a winning
    * player.
    */
   public abstract String declareWinner ();

}//end class
