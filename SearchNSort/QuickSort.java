package SearchNSort;

public class QuickSort {
    int partition(int[] arr, int low, int high){
        int i=low, j=low;
        int part= arr[high];
        while(i<=high){
            if (arr[i]<=part){
                int temp= arr[i];
                arr[i]= arr[j];
                arr[j]= temp;
                j++;
            }
            i++;
        }
        return j-1;
    }

    void sort(int arr[], int low, int high){
        int partitioner= partition(arr, low, high);
        if (low<high){
            sort(arr, low, partitioner-1);
            sort(arr, partitioner+1, high);
        }
    }
    public static void main(String[] args) {
        int arr[]= new int[]{9,5,2,4,3};
        int low=0;
        int high= arr.length-1;

        QuickSort obj1= new QuickSort();
        obj1.sort(arr, low, high);
        System.out.println("After Sorting:");

        for(int i=0;i< arr.length; i++) System.out.print(arr[i]+ "-->");
        System.out.println("NULL");

    }
}
