/*CS110 - Jack Klug - Battleship project
   Battleship driver that controls the whole game
*/
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class BattleshipDriver{
   public static void main(String[] args){
      //create the game
      Game battleship = new Game();
      System.out.println("Welcome to Battleship!");
      System.out.println("");
      
      //some variables
      String strMove;
      Move move;
      int turn = 1;
      String placeholder;
      String[] computerMoveReturn;
      String returnMessage;
      String userMoveReturn;
      
      //decide who goes first
      Scanner keyboard = new Scanner(System.in);
      Random rand = new Random();
      int coin = rand.nextInt(2);
      
      
      while(battleship.computerDefeated() == false && battleship.userDefeated() == false){
         //player goes
         if(coin == 0){
            if(turn == 1){
               System.out.println("Player won the coin toss and gets to go first.");
               System.out.print("Where would you like to move? ");
               strMove = keyboard.nextLine().toUpperCase();
               battleship.makePlayerMove(strMove);
               System.out.println(battleship.toString());
            }
            else{
               System.out.print("Your turn: ");
               strMove = keyboard.nextLine().toUpperCase();
               userMoveReturn = battleship.makePlayerMove(strMove);
               if(userMoveReturn != null)
                  System.out.printf("Computer says: %s\n", userMoveReturn);
               System.out.println(battleship.toString());
               
            }
            coin = 1;
         }
         //computer goes
         else{
            if(turn == 1){
               System.out.println("The Computer won the coin toss and gets to go first.");
               System.out.println("Computer's turn. Press enter to continue");
               placeholder = keyboard.nextLine();
               computerMoveReturn = battleship.makeComputerMove();
               strMove = computerMoveReturn[0];
               System.out.printf("Computer Chose : %s\n",strMove);
               System.out.println(battleship.toString());
            }
            else{
               System.out.println("Computer's turn. Press enter to continue");
               placeholder = keyboard.nextLine();
               computerMoveReturn = battleship.makeComputerMove();
               System.out.printf("Computer Chose: %s\n", computerMoveReturn[0]);
               returnMessage = computerMoveReturn[1];  
               if(returnMessage != null)
                  System.out.printf("To Computer: %s\n", returnMessage);
               System.out.println(battleship.toString());
            }
            coin = 0;
         }
         turn++;
         
      }
      if(battleship.computerDefeated() == true){
         System.out.println("Game Over!");
         System.out.println("You won!");
      }else{
         System.out.println("Game Over!");
         System.out.println("You Lost! The Computer Won!");
      }
   }
}