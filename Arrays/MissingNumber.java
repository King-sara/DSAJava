package Arrays;

public class MissingNumber {
    
    public static int missing(int[] arr){
        int n=arr.length+1;
        int sum=(n*(n+1))/2;

        for(int num:arr){
            sum-=num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int result=missing(new int[] {1,3,6,8,2,4,7});
        System.out.println("The missing number in the array is: "+ result);
    }
}
