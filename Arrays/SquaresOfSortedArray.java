package Arrays;

public class SquaresOfSortedArray {
    int[] sortedSquares(int[] arr){
        int i=0, j= arr.length-1;
        int newarr[]= new int[arr.length];
        for(int k=arr.length-1;k>=0;k--){
            if (Math.abs(arr[j])> Math.abs(arr[i])){
                newarr[k]= arr[j]*arr[j];
                j--;
            }
            else{
                newarr[k]= arr[i]*arr[i];
                i++;
            }
        }
        return newarr;
    }
    public static void main(String[] args) {
        int arr[]= new int[] {-4, -1, 0, 3, 10};
        SquaresOfSortedArray obj1= new SquaresOfSortedArray();
        int newarr[]=obj1.sortedSquares(arr);

        for(int i=0;i<arr.length;i++)   System.out.print(newarr[i]+ " -->");
        System.out.println("NULL");
    }
}
