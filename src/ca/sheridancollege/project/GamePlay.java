package ca.sheridancollege.project;
/**
 * @author Pranav Mistry
 */
public class GamePlay extends Game
{
   public void instructions ()
   {
      System.out.println("Welcome to UNO");
      System.out.println("Instructions: ");
      System.out.println("1) Select the number associated with a card to pick that card.");
      System.out.println("2) The card being picked needs to be either the same color or the same number as the topmost card in the pile.");
      System.out.println("3) If you pick an Invalid card you will have to pick another card from the deck.");
      System.out.println("4) The player who runs out of cards first wins the game.");
   }

   //A method overridden from the Game class
   @Override
   public void play ()
   {

      //Calling the method to set the player name before the game begins
      player.setPlayerName();

      //User takes the first turn
      System.out.println("------------------------------------------------------------------------------");
      showUserHand();
      System.out.println("Choose a card from your hand: ");
      userIndex = input.nextInt();

      if (user.getUserCards(userIndex).getCardNumber() == Cards.WILD) {
         userWild();
      }
      else if (user.getUserCards(userIndex).getCardNumber() == Cards.DRAWFOUR) {

         userDrawFour();
//            }
      }
      else if (user.getUserCards(userIndex).getCardNumber() == Cards.DRAWTWO) {
         userDrawTwo();
      }
      else {
         userDropCard();
      }

      while (running == true) {

         //Next it's the computer's turn
         showLastCardDropped();
         System.out.println("------------------------------------------------------------------------------");
         System.out.println("Computer's hand has: " + computer.getComputerSize() + " Cards");
         System.out.println("Computer's turn...");
         computerIndex = (int) (Math.random() * computer.getComputerSize());
         System.out.println("Computer chose: " + computer.getComputerCards(computerIndex).getCardNumber() + " " + computer.getComputerCards(computerIndex).getCardColor());
         if (computer.getComputerCards(computerIndex).getCardNumber() == Cards.WILD) {
            computerWild();
         }

         else if (computer.getComputerCards(computerIndex).getCardNumber() == Cards.DRAWFOUR) {
            computerDrawFour();
            continue;
         }
         else if (computer.getComputerCards(computerIndex).getCardNumber() == Cards.DRAWTWO) {
            computerDrawTwo();
         }
         else if (computer.getComputerCards(computerIndex).getCardNumber() == gp.getGamePile(gp.getGamePileSize() - 1).getCardNumber() || computer.getComputerCards(computerIndex).getCardColor() == gp.getGamePile(gp.getGamePileSize() - 1).getCardColor() && computer.getComputerCards(computerIndex).getCardNumber() != Cards.DRAWTWO) {

            computerDropCard();

         }

         else {
            System.out.println("invalid card");
            System.out.println("Computer will pick a card from the pile. ");
            if (gc.getSize() == 0) {
               System.out.println("No cards left in the game pile. GamePile size = " + gc.getSize());
            }
            else {
               int rn3 = (int) (Math.random() * gc.getSize());
               computer.addComputerCards(gc.getCards(rn3));
               gc.cards.remove(rn3);
            }
         }

         //User's turn with more functionality
         showLastCardDropped();
         System.out.println("------------------------------------------------------------------------------");
         showUserHand();
         System.out.println("Choose a card from your hand: ");
         userIndex = input.nextInt();
         if (user.getUserCards(userIndex).getCardNumber() == Cards.WILD) {
            userWild();
         }
         else if (user.getUserCards(userIndex).getCardNumber() == Cards.DRAWFOUR) {

            userDrawFour();
            continue;
//            }
         }
         else if (user.getUserCards(userIndex).getCardNumber() == Cards.DRAWTWO) {
            userDrawTwo();
         }
         else if (user.getUserCards(userIndex).getCardNumber() == gp.getGamePile(gp.getGamePileSize() - 1).getCardNumber() || user.getUserCards(userIndex).getCardColor() == gp.getGamePile(gp.getGamePileSize() - 1).getCardColor() && user.getUserCards(userIndex).getCardNumber() != Cards.DRAWTWO) {

            userDropCard();

         }


         else {
            System.out.println("invalid card");
            System.out.println("Pick from the pile? 1 for yes 2 for no and quit. ");
            int ans = input.nextInt();
            if (ans == 1) {
               System.out.println("OK");
               if (gc.getSize() == 0) {
                  System.out.println("No cards left in the game pile. GamePile size = " + gc.getSize());
               }
               else {

                  int rn4 = (int) (Math.random() * gc.getSize());
                  user.addUserCards(gc.getCards(rn4));
                  gc.cards.remove(rn4);
               }
            }
            else {
               System.out.println(declareWinner());
               running = false;
            }
         }
         if (user.getUserSize() == 0 || computer.getComputerSize() == 0) {
            System.out.println(declareWinner());
            running = false;
         }
      }

   }
   String winner;





   @Override
   public String declareWinner ()
   {
      if (user.getUserSize() == 0 || user.getUserSize() < computer.getComputerSize()) {

         winner = player.getPlayerName() + " is the winner!!";
      }
      else if (computer.getComputerSize() == 0 || computer.getComputerSize() < user.getUserSize()) {
         winner = "Computer is the winner!!";
      }
      else if (computer.getComputerSize() == user.getUserSize()) {
         winner = "It's a Tie.";
      }
      return winner;
   }
}
