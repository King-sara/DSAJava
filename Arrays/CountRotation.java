package Arrays;

public class CountRotation {
    // static int mid;

    public static int RotateCount(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if (arr[i]>arr[i+1])    return i+1;
        }
        return -1;
    }

    public static int RecurRotateCount(int[] arr, int low, int high){
        
        if (high<low)   return high+1;
        if (high==low)  return low;
        
        int mid= low+high/2;

        if (mid<high && arr[mid]>arr[mid+1])    return mid+1;
        if (mid>low && arr[mid]<arr[mid-1]) return mid;

        if (arr[high]<arr[mid])
            return RecurRotateCount(arr,mid+1,high);
        else
            return RecurRotateCount(arr,0,mid-1);
    }

    public static void main(String[] args) {
        int[] arr={3,4,5,6,1,2};

        // int ans=RotateCount(arr);
        // System.out.println(ans==-1?"It is not Rotated":"It is rotated by "+ans+" times");

        int ans=RecurRotateCount(arr,0, arr.length-1);
        System.out.println("It is rotated by "+ans+" times");
    }
}
