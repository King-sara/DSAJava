package SearchNSort;

public class BubbleSort {
    public static void SortBubble(int[] arr){
        int n= arr.length;
        for(int i=0;i<n-1;i++){
            boolean isSorted= false;
            for(int j=0;j<n-1-i;j++){
                if (arr[j]> arr[j+1]){
                    int temp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                    isSorted = true;
                }
            }
            if (isSorted== false)   break;
        }
    }
    public static void main(String[] args) {
        int arr[]= {5,1,9,2,10};
        SortBubble(arr);

        System.out.println("After Sorting:");
        for(int a: arr) System.out.print(a+ "->");
        System.out.println("NULL");
    }
}
