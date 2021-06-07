/*
    Title : To check if a string is palindrome
*/
//---------------------------------------------------------------------------------------------

import java.util.Scanner;

class Palindrome{
    static boolean isPalindrome(String str){
        int pointer1 = 0;
        int pointer2 = str.length()-1;

        while(pointer1 < pointer2){
            if(str.charAt(pointer1) == str.charAt(pointer2)){
                pointer1++;
                pointer2--;
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter input string : ");
        String str = in.nextLine();
        // System.out.println(str);
        
        if(isPalindrome(str))
            System.out.println(str+" is a palindrome");
        else
            System.out.println(str+" is not a palindrome");
    }
}