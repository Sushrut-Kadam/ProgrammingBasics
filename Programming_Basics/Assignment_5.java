/*
    Title : Perfect Number
*/
//--------------------------------------------------------------------------------------------

class Assignment_5{
    static boolean isPerfectNumber(int number){
        boolean flag = false;
        int sum = 1;

        for(int i=2; i<=number/2; i++){
            if(number%i == 0)
                sum += i;
        }

        if(sum == number)
            return true;

        return false;
    }
    
    public static void main(String[] args){
        int number = 496;

        if(isPerfectNumber(number))
            System.out.println(number+" is a perfect number");
        else
            System.out.println(number+" is not a perfect number");
    }
}
