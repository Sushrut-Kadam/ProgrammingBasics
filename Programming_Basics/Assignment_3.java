/*
    Title : Count the number of digits in an integer
 */
//----------------------------------------------------------------------------------------------

import java.util.Scanner;

 class Assignment_3{
     static int countDigits(int number){
         int digitCount = 0;

         while(number != 0){
            digitCount++;
            number = number/10;
         }

         return digitCount;
     }  

     public static void main(String[] args){
         int number = 5789;
         System.out.println(countDigits(number)+"\n");

         number = 14658792;
         System.out.println(countDigits(number));
     }
 }