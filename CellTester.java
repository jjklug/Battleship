import java.util.ArrayList;
public class CellTester
{
   public static void main(String [] args)
   {

      // demo CellStatus
//       CellStatus cell = CellStatus.AIRCRAFT_CARRIER;
//       System.out.println(cell);
//       System.out.println("What is shown on computer's board: " + 
//                      cell.toString().charAt(0));
//       System.out.println("What is shown on my board: " + 
//                      cell.toString().charAt(1));
                     
                     
             
//       // create ArrayList of CellStatus (a row)
//       ArrayList<CellStatus> row = new ArrayList<CellStatus>(3);
//       row.add(CellStatus.CRUISER);
//       row.add(CellStatus.CRUISER);
//       row.add(CellStatus.CRUISER);
//       
//       for (CellStatus status:row)
//          System.out.print(status.toString() + " ");
//       System.out.println();
//          //System.out.println(status.charAt(0));
//          //System.out.println(status.charAt(1));
     
      // Create ArrayList of ArrayList of CellStatus
      // create the container for the rows
      ArrayList<  ArrayList<CellStatus>  > board = new ArrayList<>(10); // constant??
      
      for (int i = 1; i <= 10; i++)
      {
         // create a row (like above)
          ArrayList<CellStatus> row = new ArrayList<CellStatus>(10);
          // fill the row with a status of CellStatus.NOTHING
          for (int j = 1; j <= 10; j++)
            row.add(CellStatus.NOTHING); 
          // add the row to the container
          board.add(row);
      }
      
      for (int r = 0; r < 10; r++)
      {
         for (int c = 0; c < 10; c++)
            System.out.print(board.get(r).get(c).toString().charAt(1) + " ");
            // .charAt(0)
            // .charAt(1);
         System.out.println();
      
      } 
   }
}