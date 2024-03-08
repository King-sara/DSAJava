package SearchNSort;

public class SelectionSort {
public static void SortSelect(int[] arr){
    int n= arr.length;
    for(int i=0;i<n-1;i++){
        int min=i;
        for(int j=i+1;j<n;j++){
            if (arr[min]> arr[j])   min=j;
        }

        int temp= arr[min];
        arr[min]= arr[i];
        arr[i]= temp;
    }
}

    public static void main(String[] args) {
        int arr[]= {5,1,9,2,10};
        SortSelect(arr);

        System.out.println("After Sorting:");
        for(int a: arr) System.out.print(a+ "->");
        System.out.println("NULL");
    }
}
