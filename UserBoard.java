/**CS110 - Jack Klug - Battleship Project
   UserBoard class that represents the user's board in the game of battleship. Can do everything the board class can, but has some unique features. The constructor of this class is fairly simple,
   but it creates a list of all possible moves that can be made. This class also includes a makeComputerMove, and a toString method.
*/
import java.util.ArrayList;
import java.util.Random;
public class UserBoard extends Board{
   //instance variables
   private ArrayList<Move> moves;
   private Random rand;
   
   //constructor
   /**UserBoard constructor that calls the board constructor and creates an arraylist with all possible moves
      @param filename for the file that contains board data
   */
   public UserBoard(String filename){
      super(filename);
      moves = new ArrayList<Move>(100);
      for(int i = 0; i<SIZE; i++){
         for(int j = 0; j<SIZE; j++){
            moves.add(new Move(i,j));
         }
      }
      rand = new Random();
   }
   
   /**makeComputerMove method that performs a movement for the computer on the user board
      @return returnArray that contains the data of where the move went and if it sunk a ship
   */
   public String[] makeComputerMove(){
      int randNum = rand.nextInt(moves.size());
      Move shotFired = moves.get(randNum);
      moves.remove(randNum);
      
      
      
      CellStatus whatWasHit = applyMoveToLayout(shotFired);
      String returnMessage = null;
      if(whatWasHit == CellStatus.AIRCRAFT_CARRIER){
         if(super.getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER)){
            returnMessage = "You sunk my Aircraft Carrier!";
         }
      }
      if(whatWasHit == CellStatus.BATTLESHIP){
         if(super.getFleet().updateFleet(ShipType.ST_BATTLESHIP)){
            returnMessage = "You sunk my Battleship!";
         }
      }
      if(whatWasHit == CellStatus.CRUISER){
         if(super.getFleet().updateFleet(ShipType.ST_CRUISER)){
            returnMessage = "You sunk my Cruiser!";
         }
      }
      if(whatWasHit == CellStatus.SUB){
         if(super.getFleet().updateFleet(ShipType.ST_SUB)){
            returnMessage = "You sunk my Sub!";
         }
      }
      if(whatWasHit == CellStatus.DESTROYER){
         if(super.getFleet().updateFleet(ShipType.ST_DESTROYER)){
            returnMessage = "You sunk my Destroyer!";
         }
      }
      String[] returnArray = new String[2];
      returnArray[0] = shotFired.toString();
      returnArray[1] = returnMessage;
      return returnArray;  
   }
   
   /**toString method that returns string representation of the userboard
      @return s string representation of the UserBoard
   */
   public String toString(){
      String s = "";
      int x = 65;
      s += "  1 2 3 4 5 6 7 8 9 10\n";
      for(int i =0; i< SIZE; i++){
         s += (char)x + " ";
         for(int j = 0;j<SIZE; j++){
            s = s + (super.getLayout().get(i).get(j).toString().charAt(1) + " ");
         }
         s = s + "\n";
         x++;
      }
      return s;
   }
}