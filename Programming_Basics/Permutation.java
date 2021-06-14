import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

class Permutation{

    static void permute(String str, int index_1, int index_2){
        if(index_2 == str.length())
            return;
        
        char[] input = str.toCharArray();
        char temp = input[index_1];
        input[index_1] = input[index_2];
        input[index_2] = temp;
        System.out.println(input);
        permute(str, index_1, index_2+1);
    }

    public static void main(String[] args){
        HashMap<Integer, String> table = new HashMap<>();
        String input = "abcd";
        
        int size = input.length();
        int count = 1;

        // for(int i=0; i<size; i++)
        //     table.put(count++, permute(input.toCharArray(), i, 0));

        // Collection<String> values = table.values();
        // ArrayList<String> showList = new ArrayList<>(values);
        // for(String str : showList)
        //     System.out.println(str);

        for(int i=0; i<size; i++)
            permute(input, i, 0);


    }
}