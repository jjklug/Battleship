/**CS110 - Jack Klug - Battleship Project
   ComputerBoard class is a board that represents the computers board in the game. It holds the information of its ships and does everything the board class plus some.
   It includes a makePlayerMove method and a toString method. Its constructor just calls the superclass.
*/
public class ComputerBoard extends Board{
   //constructor
   /**ComputerBoard constructor just calls the superclass' constructor and inserts the filename
      @param filename of the board
   */
   public ComputerBoard(String filename){
      super(filename);
   }
   
   //other methods
   /**makePlayerMove method that performs a move by the player on the computer board
      @param shotFired is a move made by the user
      @return String lets the user know what ship was sunk if one was
   */
   public String makePlayerMove(Move shotFired){
      CellStatus whatWasHit;
      whatWasHit = applyMoveToLayout(shotFired);
      if(whatWasHit == CellStatus.AIRCRAFT_CARRIER){
         if(super.getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER)){
            for(int i = 0; i < SIZE; i++){
               for(int j = 0; j< SIZE; j++){
                  if(super.getLayout().get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_HIT){
                     super.getLayout().get(i).set(j, CellStatus.AIRCRAFT_CARRIER_SUNK);
                  }
               }
            }
            return "You sank my Aircraft Carrier!";
         }
      }
      if(whatWasHit == CellStatus.BATTLESHIP){
         if(super.getFleet().updateFleet(ShipType.ST_BATTLESHIP)){
            for(int i = 0; i < SIZE; i++){
               for(int j = 0; j< SIZE; j++){
                  if(super.getLayout().get(i).get(j) == CellStatus.BATTLESHIP_HIT){
                     super.getLayout().get(i).set(j, CellStatus.BATTLESHIP_SUNK);
                  }
               }
            }
            return "You sank my Battleship!";
         }
      }
      if(whatWasHit == CellStatus.CRUISER){
         if(super.getFleet().updateFleet(ShipType.ST_CRUISER)){
            for(int i = 0; i < SIZE; i++){
               for(int j = 0; j< SIZE; j++){
                  if(super.getLayout().get(i).get(j) == CellStatus.CRUISER_HIT){
                     super.getLayout().get(i).set(j, CellStatus.CRUISER_SUNK);
                  }
               }
            }
            return "You sank my Cruiser!";
         }
      }
      if(whatWasHit == CellStatus.SUB){
         if(super.getFleet().updateFleet(ShipType.ST_SUB)){
            for(int i = 0; i < SIZE; i++){
               for(int j = 0; j< SIZE; j++){
                  if(super.getLayout().get(i).get(j) == CellStatus.SUB_HIT){
                     super.getLayout().get(i).set(j, CellStatus.SUB_SUNK);
                  }
               }
            }
            return "You sank my Sub!";
         }
      }
      if(whatWasHit == CellStatus.DESTROYER){
         if(super.getFleet().updateFleet(ShipType.ST_DESTROYER)){
            for(int i = 0; i < SIZE; i++){
               for(int j = 0; j< SIZE; j++){
                  if(super.getLayout().get(i).get(j) == CellStatus.DESTROYER_HIT){
                     super.getLayout().get(i).set(j, CellStatus.DESTROYER_SUNK);
                  }
               }
            }
            return "You sank my Destroyer!";
         }
      }
      return null;
   }
   
   @Override
   /**toString method for the ComputerBoard class
      @return s string representation of a computerBoard
   */
   public String toString(){
      String s = "";
      int x = 65;
      s += "  1 2 3 4 5 6 7 8 9 10\n";
      for(int i =0; i< SIZE; i++){
         s += (char)x + " ";
         for(int j = 0;j<SIZE; j++){
            s = s + (super.getLayout().get(i).get(j).toString().charAt(0) + " ");
         }
         s = s + "\n";
         x++;
      }
      return s;
   }
}