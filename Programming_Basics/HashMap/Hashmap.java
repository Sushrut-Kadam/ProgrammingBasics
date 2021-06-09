import java.util.Scanner;

class Node{
    String key;
    int value;
    Node next;

    Node(String key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    void printNode(){
        System.out.print(key+" : "+value+"\n");
    }

}


class Hashmap{
    static Node[] list = new Node[50];

    static int hash(String key){
        int size = key.length();

        char ch;
        int total = 0;

        for(int i=0; i<size; i++){
            ch = key.charAt(i);
            total += (int)ch;
        }

        // System.out.println(total%50);
        return total%50;
    }
    
    static void insertWords(String text){
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
            
            int hashValue = hash(words[i]);

            // System.out.println(words[i]+" "+hashValue);
            // System.out.println(list[hashValue]);

            if(list[hashValue] == null)
                list[hashValue] = new Node(words[i], 1);
            else{    
                Node temp = list[hashValue];
                
                boolean flag = false;
                
                while(temp.next != null){
                    if(temp.key.equals(words[i])){
                        temp.value++;
                        flag=true;
                    }
                    temp = temp.next;
                }
                if(temp.key.equals(words[i])){
                        temp.value++;
                        flag=true;
                }
                
                if(!flag)
                    temp.next = new Node(words[i], 1);
            }
            // System.out.println(list[hashValue].key);
        }
    }

    static void frequency(String key){
        int hashValue = hash(key);

        Node temp = list[hashValue];

        while((temp != null) && (!temp.key.equals(key))){
            temp = temp.next;
        }
        if(temp == null)
            System.out.println("No search found !");
        else    
            System.out.println("Occurences : "+temp.value);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        
        insertWords(str);

        System.out.print("Insert word to search : ");
        String key = in.next();
        frequency(key);
    }
}