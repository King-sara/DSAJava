package SearchNSort;

public class Mergesort {
    public void merge(int arr[], int temp[], int low, int mid, int high) {
        int i=low, j= mid+1, k=low;
        for(int a=0;a<arr.length;a++){
            temp[a]= arr[a];
        }

        while(i<=mid && j<=high){
            if (temp[i]<=temp[j])    arr[k++]= temp[i++];
            else    arr[k++]= temp[j++];
        }

        while(i<=mid)   arr[k++]= temp[i++];
        //while(j<=high)  arr[k++]= temp[j++];
    }

    public void sort(int[] arr, int temp[], int low, int high){
        if (low<high){
            int mid= low+(high-low)/2;
            //System.out.println(" Hel"+ mid);
            sort(arr, temp, low, mid);
            sort(arr, temp, mid+1, high);
            merge(arr, temp, low, mid, high);
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[] {9,5,2,4,3};
        Mergesort obj1= new Mergesort();
        obj1.sort(arr, new int[arr.length], 0, arr.length-1);
        System.out.println("After Sorting:");
        for(int i=0;i<arr.length;i++)   System.out.print(arr[i]+ "->");
        System.out.println("NULL");
    }
}
