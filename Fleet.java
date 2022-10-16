/**CS110 - Jack Klug - Battleship Project
   Fleet class that stores the information of the fleet of ships on each board. Contains a constructor, updateFleet method, and gameOver method.
*/
public class Fleet{
   //instance variables
   private Ship battleShip;
   private Ship aircraftCarrier;
   private Ship cruiser;
   private Ship sub;
   private Ship destroyer;
   
   /**Fleet constructor that instantiates all of the ships within the fleet. Battleship, cruiser, aircraft carrier, and destroyer.
   */
   public Fleet(){
      battleShip = new Battleship();
      aircraftCarrier = new AircraftCarrier();
      cruiser = new Cruiser();
      sub = new Sub();
      destroyer = new Destroyer();
   }
   
   /**updateFleet method that updates the ships of their status each time they get hit and returns whether they were sunk or not
      @param st ShipType enum value that determines which ship is being checked
      @return boolean value that says if the ship has been sunk or not
   */
   public boolean updateFleet(ShipType st){
      if (st == ShipType.ST_AIRCRAFT_CARRIER){
         aircraftCarrier.hit();
         return aircraftCarrier.getSunk();
      }
      if (st == ShipType.ST_BATTLESHIP){
         battleShip.hit();
         return battleShip.getSunk();
      }
      if(st == ShipType.ST_CRUISER){
         cruiser.hit();
         return cruiser.getSunk();
      }
      if (st == ShipType.ST_SUB){
         sub.hit();
         return sub.getSunk();
      }
      if (st == ShipType.ST_DESTROYER){
         destroyer.hit();
         return destroyer.getSunk();
      }
      return false;
   }
   
   /**gameOver method that returns whether all of the ships have been sunk
      @return boolean value that lets the user know if all the ships have been sunk
   */
   public boolean gameOver(){
      if (battleShip.getSunk() && aircraftCarrier.getSunk() && cruiser.getSunk() && sub.getSunk() && destroyer.getSunk()){
         return true;
      } return false;
   }
}