import java.util.Stack;

public class NextGreater {

    public static int[] great(int[] arr){
        int result[]= new int[arr.length];
        Stack<Integer> temp= new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            if (!temp.empty()){
                while(!temp.empty() && temp.peek()<=arr[i])
                    temp.pop();
            }

            if (temp.empty())   result[i]=-1;
            else    result[i]=temp.peek();
            temp.push(arr[i]);

        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr={4,7,3,4,8,1};

        int[] new_arr= great(arr);
        System.out.println("So, the next greater elements are:");
        for(int i=0;i<new_arr.length;i++)
            System.out.print(new_arr[i]+" ");
    }
}
