import java.util.Scanner;
import java.util.HashMap;

class wordFrequency{
    static Scanner in = new Scanner(System.in);
    static HashMap<String, Integer> map = new HashMap<>();

    static void insertInMap(String text){
        String[] words = text.split(" ");

        for(int i=0; i<words.length; i++){
            // System.out.println(words[i]);
            
            char lastChar = words[i].charAt(words[i].length()-1);
            if(((int)lastChar >= 33) && ((int)lastChar <= 47))
                words[i] = words[i].substring(0, words[i].length()-1);

            if(((int)lastChar >= 58) && ((int)lastChar <= 64))
                words[i] = words[i].substring(0, words[i].length()-1);

            if(((int)lastChar >= 91) && ((int)lastChar <= 96))
                words[i] = words[i].substring(0, words[i].length()-1);

            if(((int)lastChar >= 123) && ((int)lastChar <= 126))
                words[i] = words[i].substring(0, words[i].length()-1);
            
            if(map.get(words[i]) == null)
                map.put(words[i], 1);
            else
                map.put(words[i], map.get(words[i])+1);
        }

        // System.out.println(map.size());
    }

    static int calculateWords(String key){
        return map.get(key);
    }

    public static void main(String[] args){
        System.out.print("Enter your text : ");
        String text = in.nextLine();

        // System.out.println(text);

        insertInMap(text);

        System.out.print("Enter word to search : ");
        String key = in.next();
        System.out.println(key+" : "+calculateWords(key)+" occurrences");

    }
}