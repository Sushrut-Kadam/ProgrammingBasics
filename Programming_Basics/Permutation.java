import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Permutation{
    
    static HashSet<String> table = new HashSet<>();             //hashset is used to store only unique permutations
    
    static void permute(char[] str, int index_1, int length){
        
        for(int j=index_1; j<length; j++){
            /* 
                System.out.println(Before swap : "+String.valueOf(str)); 
            */

            swap(str, index_1, j);
            permute(str, index_1+1, length);
            
            /* 
                System.out.println("After swap : "+String.valueOf(str));
            */
            
            table.add(String.valueOf(str));
            swap(str, index_1, j);                    //we reverse the swapping to get the orignal string for swapping at the next position
            
            /* 
                System.out.println("After backtrack : "+String.valueOf(str));
            */
        }
    }

    static void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter input string : ");
        String input = in.nextLine();
        
        permute(input.toCharArray(), 0, input.length());

        /*    
            System.out.println("Number of permutations : "+table.size());
        */

        Iterator<String> iterator = table.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}