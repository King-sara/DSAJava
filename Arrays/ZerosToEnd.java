package Arrays;

public class ZerosToEnd {

    public void printArray(int[] array){
        int n=array.length;
        for(int i=0;i<n;i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }

    public void swap(int[] arr, int num1, int num2){ //Swap only by sending array
        int temp=arr[num1];
        arr[num1]=arr[num2];
        arr[num2]=temp;
    }

    public void moveZeros(int[] arr){
        //To retain the same order of array:
        int j=0;
        for(int i=0;i<arr.length;i++){
            if (arr[j]==0 && arr[i]!=0){
                swap(arr,i,j);
            }

            if (arr[j]!=0)
                j++;
        }

        printArray(arr);

        //If order needs not to be maintained- can track from the end pointer as well..
    }

    public static void main(String[] args) { //Also can create function that holds this psvm code in ZeroToEnd class
        ZerosToEnd func= new ZerosToEnd();
        int[] arr={0,1,0,2,1,0,3};
        
        func.moveZeros(arr);
    }
}
