

class wildcardExecution{

//----------------------------------------------------------------------------------------------------------------

    static String star(String input, String pattern){
        int patternSize = pattern.length();
        int inputSize = input.length();

        String key="";
        boolean patternFlag = false;

        for(int pattern_index = 0; pattern_index < patternSize; pattern_index++){
            if(pattern.charAt(pattern_index) == '*'){
                patternFlag = true;
                key = pattern.substring(0,pattern_index);
                break;                          // for * it will always be in the end
            }
        }

        if(!patternFlag){
            key = pattern;
        }

        System.out.println(key);

        int step = key.length();
        for(int input_index = 0; input_index < inputSize; input_index++){
            if(input.charAt(input_index) == key.charAt(0)){
                boolean keyFlag = false;
                input_index++;
                
                int key_index = 1;                                //because 0th index is checked already
                while(key_index < step){
                    if(input.charAt(input_index) != key.charAt(key_index)){
                        keyFlag = true;
                        break;
                    }

                    input_index++;
                    key_index++;
                }

                if(!keyFlag){
                    if(!patternFlag)
                        return input.substring(input_index-step, input_index);
                    
                    return input.substring(input_index-step);
                }
            }
        }
        return null;
    }

//----------------------------------------------------------------------------------------------------------------

    static String questionMark(String input, String pattern){
        int patternSize = pattern.length();
        int inputSize = input.length();
        boolean patternFlag = false;

        String keyLeft = "";
        String keyRight = "";
        
        for(int pattern_index = 0; pattern_index < patternSize; pattern_index++){
            if(pattern.charAt(pattern_index) == '?'){
                patternFlag = true;
                keyLeft = pattern.substring(0,pattern_index);
                keyRight = pattern.substring(pattern_index+1);
                break;
            }
        }

        if(!patternFlag){
            keyLeft = pattern;
            keyRight = "";
        }

        int leftStep = keyLeft.length();
        int rightStep = keyRight.length();
        int start,end;

        // System.out.println(keyLeft);
        // System.out.println(keyRight);

        // System.out.println(leftStep);
        // System.out.println(rightStep);


        for(int input_index = 0; input_index < inputSize; input_index++){
            if(input.charAt(input_index) == keyLeft.charAt(0)){
                start = input_index;
                boolean keyFlag = false;
                input_index++;
                
                int key_index=1;                                  //because 0th index is checked already
                while(key_index<leftStep){
                    // System.out.println("1st while = i : "+input.charAt(i)+" j : "+keyLeft.charAt(j));
                    if(input.charAt(input_index) != keyLeft.charAt(key_index)){
                        keyFlag = true;
                        break;
                    }

                    input_index++;
                    key_index++;
                }
                  
                if(patternFlag){
                    input_index++;
                    key_index = 0; 

                    while(key_index < rightStep){
                        // System.out.println("2nd while = i : "+input.charAt(i)+" j : "+keyRight.charAt(j));
                        if(input.charAt(input_index) != keyRight.charAt(key_index)){
                            keyFlag = true;
                            break;
                        }

                        input_index++;
                        key_index++;
                    }
                    
                }
                end = input_index;

                if(!keyFlag){
                    return input.substring(start,end);
                }
            }
        }
        return null;
    }

//----------------------------------------------------------------------------------------------------------------

    static String brackets(String input, String pattern){
        int patternSize = pattern.length();
        int inputSize = input.length();
        boolean patternFlag = false;

        String keyLeft = "";
        String keyRight = "";
        String key = "";

        for(int pattern_index = 0, temp=0; pattern_index < patternSize; pattern_index++){
            if(pattern.charAt(pattern_index) == '['){
                patternFlag = true;
                keyLeft = pattern.substring(0,pattern_index);
                temp = pattern_index+1;                         //index next to that of '['
            }

            if(!patternFlag){
                keyLeft = pattern;
            }
            
            if(pattern.charAt(pattern_index) == ']'){
                key = pattern.substring(temp, pattern_index);
                keyRight = pattern.substring(pattern_index+1);
                patternFlag = true;
            }

            if(!patternFlag){
                keyRight = "";
            }
        }

        int leftStep = keyLeft.length();
        int rightStep = keyRight.length();
        int keySize = key.length();

        int start,end;        

        for(int input_index = 0; input_index < inputSize; input_index++){
            if(input.charAt(input_index) == keyLeft.charAt(0)){
                start = input_index;
                boolean keyFlag = false;
                input_index++;
                
                int key_index=1;                                  //because 0th index is checked already
                while(key_index < leftStep){                      //match before bracket ..[
                    if(input.charAt(input_index) != keyLeft.charAt(key_index)){
                        keyFlag = true;
                        break;
                    }

                    input_index++;
                    key_index++;
                }
                
                if(!keyFlag){
                    key_index=0;
                    while(key_index < keySize){                     //match within bracket [..]
                        if(input.charAt(input_index) != key.charAt(key_index)){
                            keyFlag = true;
                            break;
                        }
                        input_index++;
                        key_index++;
                    }
                }

                if(!keyFlag){
                    key_index = 0;
                    while(key_index < rightStep){                   //match after bracket ]..
                        if(input.charAt(input_index) != keyRight.charAt(key_index)){
                            keyFlag = true;
                            break;
                        }

                        input_index++;
                        key_index++;
                    }
                }

                end = input_index;

                if(!keyFlag){
                    return input.substring(start, end);
                }
            }
        }
        return null;
    }

//----------------------------------------------------------------------------------------------------------------
    public static void main(String[] args){
        String input = "abcdefgh";
        String pattern = "abde";

        // System.out.println(star(input, pattern));                // for wildcard *
        // System.out.println(questionMark(input, pattern));        // for wildcard ?
        // System.out.println(brackets(input, pattern));            //for wildcard [..]
    }
}   