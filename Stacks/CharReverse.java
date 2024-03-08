import java.util.Stack;

public class CharReverse {
    public static String Reverse(String str){
        char arr[]= str.toCharArray();
        Stack<Character> temp= new Stack<>();

        for(char x:arr)
            temp.push(x);

        int i=0;
        while(!temp.empty())
            arr[i++]=temp.pop();

        return new String(arr);
    }

    public static void main(String[] args) {
        String str="ABCD";
        str=Reverse(str);

        System.out.println("After reversing, the string is: "+ str);
    }
}
