import java.util.*;

public class ValidParanthesis {
    public static boolean valid(String s){
        Stack<Character> stack= new Stack<>();

        for(char x: s.toCharArray()){
            if (x=='(' || x=='[' || x=='{')
                stack.push(x);
            else{
                if (stack.empty())  return false;
                else {
                    char top= stack.peek();
                    if ((top=='(' && x==')') || (top=='[' && x==']') || (top=='{' && x=='}'))   stack.pop();
                    else    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String input= "(())";
        System.out.println(valid(input)? "Yes, the given string is valid" : "No, the given string is Invalid");
    }
}
