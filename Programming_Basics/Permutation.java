import java.util.HashSet;
import java.util.Iterator;

class Permutation{
    
    static HashSet<String> table = new HashSet<>();
    // static int count = 1;

    static void permute(char[] str, int index_1, int index_2){
        if(index_2 == str.length){
            table.add(String.valueOf(str));
            return;
        }

        swap(str, index_1, index_2);
        permute(str, index_1, index_2+1);
        swap(str, index_1, index_2);
    }

    static void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args){
        String input = "ab";
        
        int size = input.length();
        
        permute(input.toCharArray(), 0, 0);

        Iterator<String> iterator = table.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}