/*
	Title : Write a program to check if a character is an alphabet
*/
//-------------------------------------------------------------------------------------------

package Programming_Basics;

import java.util.Scanner;

public class Assignment_1{
	
	// method to check if the character is an alphabet
	static boolean isAlphabet(char param){
		int ascii = (int)param;
		// System.out.println("ascii : "+ascii);

		if((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args){
		System.out.println(isAlphabet('A'));
		System.out.println(isAlphabet('Z'));
		System.out.println(isAlphabet('a'));
		System.out.println(isAlphabet('z'));
		System.out.println(isAlphabet('j'));
		System.out.println(isAlphabet('K'));
		System.out.println(isAlphabet('5'));
		System.out.println(isAlphabet('*'));
		System.out.println(isAlphabet('/'));
	}
}