package Arrays;

public class SortedRotate {
    public static boolean isIncremented(int arr[], int min, int max){
        for(int i=min+1;i<=max;i++){
            if (arr[i]<arr[i-1])    return false;
        }
        return true;
    }

    public static boolean isDecremented(int[] arr, int min, int max){
        for(int i=min+1;i<=max;i++){
            if (arr[i]>arr[i-1])    return false;
        }
        return true;
    }

    public static boolean isIncRotated(int[] arr, int min, int max){
        if (arr[0]<arr[arr.length-1])   
            return false;

        return ((isIncremented(arr,min,(arr.length-1))) && (isIncremented(arr,0,max)));
    }

    public static boolean isDecRotated(int[] arr, int min, int max){
        if (arr[0]>arr[arr.length-1])   return false;
        return (isDecremented(arr,max,arr.length-1)) && (isDecremented(arr,0,min));
    }

    public static boolean CheckSortedRotated(int arr[]){
        int minElement=arr[0];
        int maxElement=arr[0];

        int minIndex=0;
        int maxIndex=0;

        boolean result=false;

        for(int i=1;i<arr.length;i++){
            if (minElement>arr[i]){
                minIndex=i;
                minElement=arr[i];
            }

            if (maxElement<arr[i]){
                maxIndex=i;
                maxElement=arr[i];
            }
        }

        if (maxIndex==minIndex-1)
        {
            System.out.println("It is an Incremental Array..");
            result= isIncRotated(arr, minIndex, maxIndex);
        }

        if (minIndex==maxIndex-1){
            System.out.println("It is a Decremental Array..");
            result= isDecRotated(arr, minIndex, maxIndex);
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[]={ 3, 4, 5, 1, 2 };

        System.out.println(CheckSortedRotated(arr)? "The given array is Sorted Rotated" : "The given array is not sorted Rotated");
    }
}
