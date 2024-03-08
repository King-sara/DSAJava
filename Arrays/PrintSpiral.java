package Arrays;

public class PrintSpiral {
    public static void printer(int[][] matrix, int r, int c){
        int i, k=0, l=0;
        while(k<r && l<c){
            for(i=l;i<c;i++){
                System.out.print(matrix[k][i]+ ",");
            }
            k++;
            for(i=k;i<r;i++){
                System.out.print(matrix[i][c-1]+ ",");
            }
            c--;
            if (k<r){
                for(i=c-1;i>=l;i--){
                    System.out.print(matrix[r-1][i]+ ",");
                }
                r--;
            }
            if(l<c){
                for(i=r-1;i>=k;i--){
                    System.out.print(matrix[i][l]+ ",");
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat={{10,20,30},{13,23,33},{18,28,38}};
        printer(mat, mat.length, mat.length);
    }
}
