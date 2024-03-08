package Arrays;

public class SearchSortedMatrix {
    public static boolean search(int[][] matrix, int key){
        int n= matrix.length;
        int i=0, j=n-1;

        while(i<n && j>=0){
            if (matrix[i][j]==key)
                return true;
            else if (matrix[i][j]>key){
                j--;
            }
            else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[][]= {{10,20,30},{13,23,33},{18,28,38}};
        System.out.println(search(arr, 15)? "Element is found" : "Element is not found");
    }
}
