package SearchNSort;

public class InsertionSort {
    public static void SortInsert(int[] arr){
        int n= arr.length;
        for(int i=1;i<n;i++){
            int temp= arr[i];
            int j= i-1;
            while (j>=0 && arr[j]> temp) {
                arr[j+1]= arr[j];
                j--;
            }
            arr[j+1]= temp;
        }
    }
    public static void main(String[] args) {
        int arr[]= {5,1,9,2,10};
        SortInsert(arr);

        System.out.println("After Sorting:");
        for(int a: arr) System.out.print(a+ "->");
        System.out.println("NULL");
    }
}