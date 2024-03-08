package Arrays;

public class CircularlySortedArray {
    
    public static boolean ArraySort(int[] arr){
        int count=0;

        for(int i=1;i<arr.length;i++){
            if (arr[i]<arr[i-1]){
                count++;
            }
        }

        if (count==0){
            return true;
        }
        else if (count==1){
            return arr[0]>arr[arr.length-1];
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        int arr[]={12, 17, 19, 23, 34, 45};

        System.out.println("Increasingly circularly sorted array:");
        System.out.println((ArraySort(arr))?"It is a circularly sorted array":"It is not circularly sorted");
    }
}

//Source: GeeksForGeeks
//But not checking for sorted array...
