package STACK;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String string){
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < string.length() ; i++){
            Character c = string.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{

                if(stack.isEmpty()){
                    return false;
                }

                char topStack = stack.pop();

                if(c == '}' && topStack != '{'){
                    return false;
                }


                if(c == ']' && topStack != '['){
                    return false;
                }


                if(c == ')' && topStack != '('){
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
