package Arrays;

public class FirstMinimum {
    public int firstMini(int[] arr){
        if (arr==null || arr.length==0)
            throw new IllegalArgumentException("Invalid Array..");

        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if (arr[i]<min)
                min=arr[i];
        }

        return min;
    }

    public static void main(String[] args) {
        FirstMinimum minima= new FirstMinimum();
        int[] arr= {5,9,15,1,2};
        System.out.println("Minimum value is: " +minima.firstMini(arr));

        System.out.println("Minimum value is: " +minima.firstMini(null)); //Similarly can pass new int[0]
    }
}
