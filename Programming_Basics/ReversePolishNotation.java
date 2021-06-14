/**
    Title: Evaluating the Reverse Polish Notation
 */

//----------------------------------------------------------------------------------------------

import java.util.Scanner;
import java.util.Stack;

class ReversePolishNotation{
    
    static int postfixEvaluation(String postfix){
        Stack<Integer> stk = new Stack<>();

        int size = postfix.length();

        char element;
        int operand1, operand2;

        for(int i=0; i<size; i++){
            element = postfix.charAt(i);
            // System.out.println("element : "+element);

            switch(element){
                case '+' : 
                            operand1 = stk.pop();
                            operand2 = stk.pop();
                            stk.push(operand1+operand2);
                            break;

                case '-' : 
                            operand1 = stk.pop();
                            operand2 = stk.pop();
                            stk.push(operand2-operand1);
                            break;

                case '*' : 
                            operand1 = stk.pop();
                            operand2 = stk.pop();
                            stk.push(operand1*operand2);
                            break;

                case '/' : 
                            operand1 = stk.pop();
                            operand2 = stk.pop();
                            stk.push(operand2/operand1);
                            break;

                default: stk.push(Character.getNumericValue(element));
            }

            // System.out.println(stk);
        }

        return(stk.pop());

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("\nEnter postfix expression : ");
        String expression = in.nextLine();

        System.out.println(expression+" = "+postfixEvaluation(expression)+"\n");
        // postfixEvaluation(expression);
    }
}