import java.util.HashSet;
import java.util.Iterator;
class Permutation{
    
    static HashSet<String> table = new HashSet<>();
    // static int count = 1;

    static void permute(String str, int index_1, int index_2){
        if(index_2 == str.length())
            return;
        
        char[] input = str.toCharArray();
        char temp = input[index_1];
        input[index_1] = input[index_2];
        input[index_2] = temp;
        // System.out.println(input);
        table.add(String.valueOf(input));
        permute(str, index_1, index_2+1);
        permute(String.valueOf(input), index_1, index_2+1);
    }

    public static void main(String[] args){
        String input = "abcd";
        
        int size = input.length();
        
        for(int i=0; i<size; i++)
            permute(input, i, 0);

        Iterator<String> iterator = table.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // Collection<String> values = table.values();
        // ArrayList<String> showList = new ArrayList<>(values);
        // for(String str : showList)
        //     System.out.println(str);


    }
}