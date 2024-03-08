package Arrays;

public class ArrayReversee {
    
    public static void printArray(int[] array){
        int n=array.length;
        for(int i=0;i<n;i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int num1, int num2){ //Swap only by sending array
        int temp=arr[num1];
        arr[num1]=arr[num2];
        arr[num2]=temp;
    }

    public static void reverse(int[] arr){
        int start=0;
        int n=arr.length-1;

        while(start<n){
            swap(arr,start,n);
            start++;
            n--;
        }

        printArray(arr);
    }

    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};
        reverse(arr);
        printArray(arr); //Original array gets modified
    }
}
