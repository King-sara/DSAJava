package SearchNSort;

public class BinarySearch {
    public static int search(int[] arr, int key){
        int low=0;
        int high= arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if (arr[mid]==key)  return mid;
            else if (arr[mid]>key)  high=mid-1;
            else    low=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr= {1,10,20,47,59,75,88,99};
        int num= search(arr, 98);
        System.out.println(num>0? "The key is found at the index "+ num: "The key is not found in the array.");
    }
}

//Binary Search itself if returns low at he end, then it becomes placing element in the proper position (131)
