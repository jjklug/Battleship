/**CS110 - Jack Klug - Battleship Project
   Game class that is a representation of the whole game of battleship and brings all of the classes together
*/
import java.util.Scanner;
public class Game{
   //instance variables
   private ComputerBoard computer;
   private UserBoard user;
   
   //constructor
   /**Game constructor that instantiates the user and computer boards
   */ 
   public Game(){
      computer = new ComputerBoard("compFleet.txt");
      user = new UserBoard("userFleet.txt");
   }
   
   //other methods
   /**makeComputerMove method that calls the userBoard's makeComputerMove method and returns the output
      @return returnArray that contains where the computer moved and if it sunk a ship
   */
   public String[] makeComputerMove(){
      String[] returnArray = user.makeComputerMove();
      return returnArray;
   }
   
   /**makeUserMove method that calls the ComputerBoard's makeUserMove method and returns the output
      @return returnMessage that says if a ship was sunk on the move
   */
   public String makePlayerMove(String moveMade){
      Scanner keyboard = new Scanner(System.in);
      while (((((int)moveMade.charAt(0)) < 65) || (((int)moveMade.charAt(0)) > 74)) || (((int)moveMade.charAt(1)) < 49 || (((int)moveMade.charAt(1)) > 57))){
         System.out.print("Valid form is 'A1', try again: ");
         moveMade = keyboard.nextLine().toUpperCase();
      }
      Move shotFired = new Move(moveMade);
      while (!computer.moveAvailable(shotFired)){
         System.out.print("Location not available, try again: ");
         moveMade = keyboard.nextLine().toUpperCase();
         shotFired = new Move(moveMade);
      }
      String returnMessage = computer.makePlayerMove(shotFired);
      return returnMessage;
   }
   
   /**computerDefeated method that says whether the computer has lost the game
      @return boolean value that says if the computer has lost or not
   */
   public boolean computerDefeated(){
      if(computer.gameOver() == true)
         return true;
      return false;
   }
   
   /**userDefeated method that says whether the user has lost the game
      @return boolean value that says if the user has lost or not
   */
   public boolean userDefeated(){
      if(user.gameOver() == true)
         return true;
      return false;
   }
   
   @Override
   /**toString method that gives a full string representation of both the user board and computer board together
      @return s string representation of the user and computer boards
   */
   public String toString(){
      String s;
      s = String.format("COMPUTER \n%s \nUSER \n%s",computer.toString(), user.toString());
      return s;
   }
}