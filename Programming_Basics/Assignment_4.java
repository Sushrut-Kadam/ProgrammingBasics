/*
    Title : Number to words
 */
//---------------------------------------------------------------------------------------------

class Assignment_4{
    static String[] power = { 
                        "thoudsands", 
                        "millions",
                        "billions",
                        "trillions",
                        "quadrillions"
                    };

    static String[] doubleDigit = {
                        "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
                        "ninety"
    };                        

    static String[] words = {
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen"
    };
// ----------------------------------------------------------------------------------------------
    /*
    static void numberToWords(String number){
        int size = number.length();

        for(int i=0; i<size-1; i++){
            System.out.print(words[(((int)number.charAt(i))-48)-1]+" "+table[size-i-2]+" ");
        }
        
        System.out.println(words[(((int)number.charAt(size-1))-48)-1]);
    }
    */
// -----------------------------------------------------------------------------------------------

    static void westernFormat(String number){
        int size = number.length();
        int lastGroup = size % 3;
        int groups = size/3;

        String index;
        int position = 0;

        // System.out.println("lastGroup : "+lastGroup);
        // System.out.println("groups : "+groups);

        if(lastGroup > 0){
            index = number.substring(0,lastGroup);
            printGroup(index);
            System.out.print(power[groups-1]+" ");
            position += lastGroup;
        }

        while(groups > 1){
            index = number.substring(position, position+3);
            printGroup(index);
            System.out.print(power[groups-2]+" ");
            groups--;
            position = position+3;
        }
        index = number.substring(position, position+3);
        printGroup(index);
    }

// -----------------------------------------------------------------------------------------------

    static void printGroup(String index){
        int size = index.length();

        if(size == 1)
            System.out.print(words[Integer.parseInt(index.substring(0))-1]+" ");

        if(size == 3){
            int pos1 = Integer.parseInt(index.substring(0,1));
            System.out.print(words[pos1-1]+" hundred ");
            size--;
        }

        if(size == 2){
            int pos2 = Integer.parseInt(index.substring(1,2));

            if(pos2 <= 1){
                System.out.print(words[Integer.parseInt(index.substring(1))-1]+" ");
            }
            else{
                System.out.print(doubleDigit[pos2-2]+"-"+words[Integer.parseInt(index.substring(2))-1]+" ");
            }
        }  
    
    }

// -----------------------------------------------------------------------------------------------
    public static void main(String[] args){
        String input = "6148371289573447";
        westernFormat(input);
        System.out.println();
        
        // printGroup("345");
        // System.out.println();
        // printGroup("113");
        // System.out.println();
        // printGroup("241");
        // System.out.println();
        // printGroup("123");
        // System.out.println();
        // printGroup("215");
    }
}
