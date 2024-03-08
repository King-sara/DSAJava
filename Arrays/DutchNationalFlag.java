package Arrays;

public class DutchNationalFlag{

    public void printArray(int[] array){
        // System.out.println("print");
        int n=array.length;
        for(int i=0;i<n;i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }


    public void swap(int[] arr, int num1, int num2){ //Swap only by sending array
        int temp=arr[num1];
        arr[num1]=arr[num2];
        arr[num2]=temp;
    }

    public void sortNumber(int[] arr){
        int i=0;
        int j=0;
        int k=arr.length-1;

        while (i<=k){ //Time= O(n)
            if (arr[i]==0){
                swap(arr, i, j);
                i++;
                j++;
            }
            else if (arr[i]==1){
                i++;
            }
            else if (arr[i]==2){
                swap(arr, i, k);
                k--;
            }
        }
        printArray(arr);
    }

    public static void main(String[] args) {
        DutchNationalFlag obj= new DutchNationalFlag();
        obj.sortNumber(new int[] {2,0,2,2,0,1,1});
    }
}