/*CS110 - Jack Klug - Battleship project
   Move class that holds the value of a move in x,y form. Contains two constructors, accessors, and a toString.
*/

public class Move{
   //instance variables
   private int row;
   private int col;
   
   //constructor
   /**Move class constructor that defines a move that the player or computer will call in the game
      @param row of the board that the move is on
      @param col column of the board that the move is on
   */
   public Move(int row, int col){
      this.row = row;
      this.col = col;
   }
   /**Alternate move constructor that takes a string form of the move
      @param pos the string form of a move like 'A1'
   */
   public Move(String pos){
      char character = pos.charAt(0);
      this.row = ((int)character)-65;
      this.col = ((int)pos.charAt(1))-49;
      if(pos.length() > 2)
         this.col = 9;
   }
   
   //getters
   /**getter for the row variable
      @return row of the move that is being made
   */
   public int row(){
      return row;
   }
   /**getter for the col variable
      @return col of the move that is being made
   */
   public int col(){
      return (col);
   }
   
   @Override
   /**toString method for the Move class uses ascii values to convert integer values to char and then string
      @return s string representation of the move class like 'A1'
   */
   public String toString(){
      char c = (char)(row+65);
      String s1 = String.valueOf(c);
      String s = String.format("%s-%d",c ,col+1);
      return s;
   }
}