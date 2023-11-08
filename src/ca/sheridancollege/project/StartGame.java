package ca.sheridancollege.project;
/**
 * @author Pranav Mistry
 */
public class StartGame
{
   public static void main (String[] args)
   {
      GamePlay gamePlay = new GamePlay();
      gamePlay.instructions();
      gamePlay.assignCards();
      gamePlay.play();
   }
}
