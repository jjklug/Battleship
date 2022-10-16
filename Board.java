/**CS110 - Jack Klug - Battleship project
   Board class that represents a board in the game of battleship. Could be either the user or the computer's board. Contains a super important constructor that puts together the board based on a file.
   This class also includes accessors for the layout and fleet, as well as an applyMoveToLayout method, a moveAvailable method, and a gameOver method.
*/
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.util.ArrayList;

public class Board{
   //instance variables
   private ArrayList<ArrayList<CellStatus>> layout;
   private Fleet fleet;
   public final int SIZE = 10;
   
   //for board constructor
   private String line;
   private String[] splitLine;
   private String shipType;
   private String startShip;
   private String endShip;
   private int startRow;
   private int startCol;
   private int endRow;
   private int endCol;
   
   
   //constructor
   /**Board constructor that puts together the board from scratch. It first fills it with empty cells and then reads a file to place the ships across the board
      @param filename the file that the ship locations come from
   */
   public Board(String filename){
      layout = new ArrayList<ArrayList<CellStatus>>();
      for(int i = 0; i<SIZE; i++){
         layout.add(new ArrayList<CellStatus>());
         for(int j=0;j<SIZE; j++){
            layout.get(i).add(CellStatus.NOTHING);
         }
      }
      try{
         Scanner infile = new Scanner(new File(filename));
      
         while(infile.hasNext()){
            line = infile.nextLine();
            splitLine = line.split(" ");
            shipType = splitLine[0];
            startShip = splitLine[1];
            endShip = splitLine[2];
            startRow = ((int)startShip.charAt(0))-65;
            endRow = ((int)endShip.charAt(0))-65;
            startCol = ((int)startShip.charAt(1))-49;
            endCol = ((int)endShip.charAt(1))-49;
            
            if(endShip.length() > 2)
               endCol = 9;
            if(startShip.length() > 2)
               startCol = 9;
            
            if (shipType.equals("A")){
               //checks if horiz
               if(startRow == endRow){
                  for(int i = startCol; i <= endCol; i++){
                     layout.get(startRow).set(i,CellStatus.AIRCRAFT_CARRIER);
                  }
               }
               //vertical
               else{
                  for(int i = startRow; i <= endRow; i++){
                     layout.get(i).set(startCol,CellStatus.AIRCRAFT_CARRIER);
                  }
               }
            } else if (shipType.equals("B")){
            //checks if horiz
               if(startRow == endRow){
                  for(int i = startCol; i <= endCol; i++){
                     layout.get(startRow).set(i,CellStatus.BATTLESHIP);
                  }
               }
               //vertical
               else{
                  for(int i = startRow; i <= endRow; i++){
                     layout.get(i).set(startCol,CellStatus.BATTLESHIP);
                  }
               }
            } else if (shipType.equals("D")){
            //checks if horiz
               if(startRow == endRow){
                  for(int i = startCol; i <= endCol; i++){
                     layout.get(startRow).set(i,CellStatus.DESTROYER);
                  }
               }
               //vertical
               else{
                  for(int i = startRow; i <= endRow; i++){
                     layout.get(i).set(startCol,CellStatus.DESTROYER);
                  }
               }
            } else if (shipType.equals("S")){
            //checks if horiz
               if(startRow == endRow){
                  for(int i = startCol; i <= endCol; i++){
                     layout.get(startRow).set(i,CellStatus.SUB);
                  }
               }
               //vertical
               else{
                  for(int i = startRow; i <= endRow; i++){
                     layout.get(i).set(startCol,CellStatus.SUB);
                  }
               }
            } else if (shipType.equals("C")){
            //checks if horiz
               if(startRow == endRow){
                  for(int i = startCol; i <= endCol; i++){
                     layout.get(startRow).set(i,CellStatus.CRUISER);
                  }
               }
               //vertical
               else{
                  for(int i = startRow; i <= endRow; i++){
                     layout.get(i).set(startCol,CellStatus.CRUISER);
                  }
               }
            }
         }
      infile.close();
      
      } catch(IOException e){
         System.exit(0);
      }
      fleet = new Fleet();
   }
   
   //other methods
   /**applyMoveToLayout method that take a move and adjusts the bored based on the move
      @param shotFired move that the player or computer made
      @return CellStatus value that was there prior to the move
   */
   public CellStatus applyMoveToLayout(Move shotFired){
      CellStatus targetedCell = layout.get(shotFired.row()).get(shotFired.col());
      if (targetedCell == CellStatus.NOTHING){
         layout.get(shotFired.row()).set(shotFired.col(), CellStatus.NOTHING_HIT);
         return CellStatus.NOTHING;
      }
      
      if (targetedCell == CellStatus.AIRCRAFT_CARRIER){
         layout.get(shotFired.row()).set(shotFired.col(), CellStatus.AIRCRAFT_CARRIER_HIT);
         return CellStatus.AIRCRAFT_CARRIER;
      }
      
      if (targetedCell == CellStatus.SUB){
         layout.get(shotFired.row()).set(shotFired.col(), CellStatus.SUB_HIT);
         return CellStatus.SUB;
      }
      if (targetedCell == CellStatus.DESTROYER){
         layout.get(shotFired.row()).set(shotFired.col(), CellStatus.DESTROYER_HIT);
         return CellStatus.DESTROYER;
      }
      if (targetedCell == CellStatus.CRUISER){
         layout.get(shotFired.row()).set(shotFired.col(), CellStatus.CRUISER_HIT);
         return CellStatus.CRUISER;
      }
      else{
         layout.get(shotFired.row()).set(shotFired.col(), CellStatus.BATTLESHIP_HIT);
         return CellStatus.BATTLESHIP;
      }
   }
   
   /**moveAvailable method that checks if the move is still available to be performed on the board
      @param possibleMove move that is being checked
      @return boolean value depeding on whether the move is available
   */
   public boolean moveAvailable(Move possibleMove){
      CellStatus targetedCell = layout.get(possibleMove.row()).get(possibleMove.col());
      if(targetedCell == CellStatus.NOTHING || targetedCell == CellStatus.AIRCRAFT_CARRIER || targetedCell == CellStatus.BATTLESHIP || targetedCell == CellStatus.CRUISER ||
         targetedCell == CellStatus.DESTROYER || targetedCell == CellStatus.SUB){
         return true;
      }return false;
   }
   
   /**getLayout method that returns the layout
      @return layout of the board
   */
   public ArrayList<ArrayList<CellStatus>> getLayout(){
      return layout;
   }
   
   /**getFleet method that returns the fleet
      @return fleet on the board
   */
   public Fleet getFleet(){
      return fleet;
   }
   
   /**gameOver method that checks if all the ships are sunk
      @return boolean value that shows whether all ships are sunk
   */
   public boolean gameOver(){
      CellStatus currCell;
      for(int i = 0;i< SIZE;i++){
         for(int j = 0;j<SIZE;j++){
            currCell = layout.get(i).get(j);
            if (currCell == CellStatus.AIRCRAFT_CARRIER || currCell == CellStatus.AIRCRAFT_CARRIER_HIT || currCell == CellStatus.BATTLESHIP || currCell == CellStatus.BATTLESHIP_HIT || currCell == CellStatus.CRUISER_HIT
               || currCell == CellStatus.CRUISER || currCell == CellStatus.SUB || currCell == CellStatus.SUB_HIT || currCell == CellStatus.DESTROYER || currCell == CellStatus.DESTROYER_HIT){
               return false;
            }
         }
      }
      return true;
   }
   
}