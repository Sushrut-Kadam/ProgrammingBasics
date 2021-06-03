/*
    Title : Number to words
 */
//---------------------------------------------------------------------------------------------

class Assignment_4{
    static String[] table = { 
                                "tens", 
                                "hundreds", 
                                "thoudsands", 
                                "ten-thousands", 
                                "lakhs", 
                                "ten-lakhs", 
                                "crore" 
    };
                        
    static String[] words = {
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    static void numberToWords(String number){
        int size = number.length();

        for(int i=0; i<size-1; i++){
            System.out.print(words[(((int)number.charAt(i))-48)-1]+" "+table[size-i-2]+" ");
        }
        
        System.out.println(words[(((int)number.charAt(size-1))-48)-1]);
    }

    public static void main(String[] args){
        String input = "128547";
        numberToWords(input);
    }
}
