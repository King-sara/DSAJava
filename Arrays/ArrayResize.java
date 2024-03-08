package Arrays;

public class ArrayResize {
    public void printArray(int[] array){
        int n=array.length;
        for(int i=0;i<n;i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }

    public int[] resize(int arr[], int capacity){
        int new_arr[] = new int[capacity];
        for(int i=0;i<arr.length;i++){
            new_arr[i]=arr[i];
        }

        arr=new_arr; //If wanted use here..
        return arr;
    }

    public static void main(String[] args) {
        ArrayResize func= new ArrayResize();
        int arr[]= {1,2,3,4,5};
        func.printArray(arr);

        int new_arr[]=func.resize(arr, 8); //To resize, return the array (Important..)
        func.printArray(new_arr);

        arr= new_arr;  //Assign to use the same array.
        func.printArray(arr);
    }
}
