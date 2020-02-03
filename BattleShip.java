//Minh Thao  Pd: 6

import java.io.*;
import java.util.*;

public class BattleShip
{

   public static void setUp(String[][]board)
   { 
      
      for(int c = 0; c<8; c++)
      {
         for(int k = 0; k<8; k++)
         {
            board[c][k]= "~"; 
         }
      }
      
      int p = (int)(Math.random()*2)+1;
      if(p == 1)
      {
         int r = (int)(Math.random()*8);
         int c = (int)(Math.random()*5);
         for(int y = 0; y<4; y++)
         {
            board[r][c] = "S";
            c = c+1;
         }
      }
      else
      {
         int c = (int)(Math.random()*8);
         int r = (int)(Math.random()*5);
         for(int y = 0; y<4; y++)
         {
            board[r][c] = "S";
            r = r+1;
         }
      }
   }
   
   public static void show(String[][]board)
   {
      for(int k = 0; k<8; k++)
      { 
         if(k == 0)
            System.out.print(" ");
         
         System.out.print(" " + k);
      }
      System.out.println();
      
      for(int d = 0; d<8; d++)
      {
         System.out.print(d + " ");
         for(int k = 0; k<8; k++)
         {
            if(board[d][k] == "S")
            {
               System.out.print("~ ");
            }
            else
            {
               System.out.print(board[d][k] + " ");
            } 
         }
         System.out.println();
      }
   }

   public static void udBoard(String[][]board, int r, int c)
   {
      if(board[r][c] == "S")
      {
         board[r][c] = "!";
      }
      else
      {
         board[r][c] = "m";
      }    
   }   
   
   public static void main(String[]arg)
   {
      Scanner input = new Scanner(System.in);
   
      String[][] sea = new String[8][8]; 
      setUp(sea);
      
      int h = 0;
      int t = 15;
      show(sea);
      
      while(h < 4 && t>0)
      {
      
         System.out.println("pick a row to fire on: ");
         int r = input.nextInt();
         System.out.println("pick a col to fire on: ");
         int c = input.nextInt();
         
         while(r < 0 || r>=8 || c < 0 || c >= 8)
         {
            System.out.println("Error: Invalid coordinate.");
            System.out.println("pick a row to fire on: ");
            r = input.nextInt();
            System.out.println("pick a col to fire on: ");
            c = input.nextInt();
         }
         
         while(sea[r][c] == "!" || sea[r][c] == "m")
         {
            System.out.println("Error: you already fire on this coordinate.");
            System.out.println("pick a row to fire on: ");
            r = input.nextInt();
            System.out.println("pick a col to fire on: ");
            c = input.nextInt();
         }
         
         udBoard(sea, r, c);
         t--;
         
         if(sea[r][c] == "!")
         {
            h++;
         }
         show(sea);
         if(h == 4)
         {
            System.out.println("You win.");
         }
         else
         {
            if(t > 0)
            {
               System.out.println("You have " + t + " topedoes left"); 
            }
            else
            {
               System.out.println("You have 0 topedoes, try again.");
            }
         }
      }
   } 
}