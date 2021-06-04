/*
    Title : Number to words
 */
//---------------------------------------------------------------------------------------------

class Assignment_4{
    static String[] indianPower = { 
                        "thoudsand", 
                        "lakh",
                        "crore",
                        "arab",
                        "kharab",
                        "nil",
                        "padma",
                        "shankh"
                    };
    
    static String[] westernPower = { 
                        "thoudsand", 
                        "million",
                        "billion",
                        "trillion",
                        "quadrillion",
                        "pentillion"
                    };

    static String[] doubleDigit = {
                        "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
                        "ninety"
    };                        

    static String[] singleDigit = {
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

    static void indianFormat(String number){
        int size = number.length();
        size = size-3;

        int lastGroup = size%2;
        int groups = size/2;

        String index;
        int position = 0;

        if(lastGroup > 0){
            index = number.substring(0,lastGroup);
            printGroup(index);
            System.out.print(indianPower[groups]+" ");
            position += lastGroup;
        }

        while(groups > 0){
            index = number.substring(position, position+2);
            printGroup(index);
            System.out.print(indianPower[groups-1]+" ");
            groups--;
            position = position+2;
        }
        index = number.substring(position, position+3);
        printGroup(index);
        

    }

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
            System.out.print(westernPower[groups-1]+" ");
            position += lastGroup;
        }

        while(groups > 1){
            index = number.substring(position, position+3);
            printGroup(index);
            System.out.print(westernPower[groups-2]+" ");
            groups--;
            position = position+3;
        }
        index = number.substring(position, position+3);
        printGroup(index);
    }

// -----------------------------------------------------------------------------------------------

    static void printGroup(String index){
        int size = index.length();

        if(size == 3){
            // int pos1 = Integer.parseInt(index.substring(0,1));
            int pos1 = Integer.parseInt(index.substring(size-3,size-3+1));
            System.out.print(singleDigit[pos1-1]+" hundred ");

            int pos2 = Integer.parseInt(index.substring(size-2,size-2+1));

            if(pos2 <= 1){
                System.out.print(singleDigit[Integer.parseInt(index.substring(size-2))-1]+" ");
            }
            else{
                System.out.print(doubleDigit[pos2-2]+"-"+singleDigit[Integer.parseInt(index.substring(size-1))-1]+" ");
            }
        }

        if(size == 2){
            // int pos2 = Integer.parseInt(index.substring(1,2));
            int pos2 = Integer.parseInt(index.substring(size-2,size-2+1));

            if(pos2 <= 1){
                System.out.print(singleDigit[Integer.parseInt(index.substring(size-2))-1]+" ");
            }
            else{
                System.out.print(doubleDigit[pos2-2]+"-"+singleDigit[Integer.parseInt(index.substring(size-1))-1]+" ");
            }
        }  

        if(size == 1)
            System.out.print(singleDigit[Integer.parseInt(index.substring(0))-1]+" ");
    
    }

// -----------------------------------------------------------------------------------------------
    public static void main(String[] args){
        String input = "1483712914"; 
        System.out.println("Western System : ");
        westernFormat(input);
        System.out.println("\n");
        
        System.out.println("Indian System : ");
        indianFormat(input);
        System.out.println();
    }
}
