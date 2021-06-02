/*
    Title : To check if a character is an alphabet
*/
//---------------------------------------------------------------------------------------------

class Assignment_1{
    static boolean isAlphabet(char ch){
        int ascii = (int)ch;

        if((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122))
            return true;

        return false;
    }

    public static void main(String[] args){
        
        System.out.println(isAlphabet('a'));
        System.out.println(isAlphabet('J'));
        System.out.println(isAlphabet('K'));
        System.out.println(isAlphabet('1'));
        System.out.println(isAlphabet('$'));
        System.out.println(isAlphabet('_')); 
    }
}