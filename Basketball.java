//Minh Thao

import java.io.*;
import java.util.*;

public class Basketball
{
   public static void getScore(int[][] Score, String a, String b)throws IOException
   {
      Scanner input = new Scanner(System.in);
   
      for(int c = 0; c<4;c++)
      {
         for(int i = 0; i<1; i++)
         {
            int d =c+1;
            System.out.println("Enter the " + a + " score for quater " + d +":");
            Score[i][c] = input.nextInt();
            System.out.println("Enter the " + b + " score for quater " + d +":");
            Score[i+1][c] = input.nextInt();
         }
      }
   }
   
   public static void show(int[][] Score, String a, String b)
   { 
      for(int i = 0; i<2; i++)
      {
         if(i==0)
         {
            System.out.print(a + " ");
            int x = a.length();
            while(x<b.length())
            {
               System.out.print(" ");
               x++;
            }
         }
         for(int c = 0; c<6; c++)
         {
            System.out.print(Score[i][c]+" ");
            
            int x = Score[0][c];
            int y = Score[1][c];
            int x1 = 0;
            int y1 = 0;
            
            while(x>0)
            {
               x = x/10;
               x1++;
            }
            
            while(y>0)
            {
               y = y/10;
               y1++;
            }
            
            if(Score[i][c] == Score[1][c])
            {
               while(y1<x1)
               {
                  System.out.print(" ");
                  y1++;
               }
            }
            else
            {
               while(x1<y1)
               {
                  System.out.print(" ");
                  x1++;
               }   
            }
         }
         System.out.println();
         if(i==0)
         {
            System.out.print(b + " ");
            int x = b.length();
            while(x<a.length())
            {
               System.out.print(" ");
               x++;
            }
         }
      }
      
      if(Score[0][5]>Score[1][5])
      {
         int x = Score[0][5]-Score[1][5];
         System.out.println("The " + a +" win by " + x +"!");
      }
      else
      {
         int x = Score[1][5]-Score[0][5];
         System.out.println("The " + b + " win by " + x +"!");
      }
   }  
   
   public static void calScore(int[][] Score)
   {
      for(int j = 0; j<2; j++)
      {
         for(int k = 0; k< 2; k++)
         {
            Score[j][4] = Score[j][k] + Score[j][4];
         }
       
         for(int l = 0; l<4; l++)
         {
            Score[j][5] = Score[j][l] + Score[j][5];
         }
      }
   }
   
   public static void main(String[]arg)throws IOException
   {
      Scanner input = new Scanner(System.in);
    
      int[][] list = new int[2][6];
      String a, b;
    
      System.out.println("Enter the name for the home team: ");
      a = input.next();
      System.out.println("Enter the name for the visiting team: ");
      b = input.next();
   
      getScore(list,a,b);
      calScore(list);
      show(list,a,b);
   }
}
