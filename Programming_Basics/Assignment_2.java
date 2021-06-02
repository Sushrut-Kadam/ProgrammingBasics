/*
    Title : Find total occurrences of each digits (0-9) using function.
 */

 import java.util.Scanner;

 class Assignment_2{ 

     //method to find the occurrences of each digit in a number
     static void findOccurrences(int num){
         int[] digitsFrequency = new int[10];
         
         while(num != 0){
            int digit = num%10;
            num = num/10;
            digitsFrequency[digit]++;
         }

         for(int i=0; i<10; i++){
             System.out.println(i+" : "+digitsFrequency[i]+" occurrences");
         }
         System.out.println();
     }

     public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number : ");
        int number = in.nextInt();

        findOccurrences(number);
     }
 }