package SearchNSort;

public class Sort2Array {
    public static int[] SortSortedArray(int[] arr1, int[] arr2){
        int i=0, j=0, k=0;
        int m= arr1.length, n= arr2.length;
        int ans[]= new int[m+n];
        
        while(i<m && j<n){
            if (arr1[i]<arr2[j]){
                ans[k++]= arr1[i++];
            }
            else{
                ans[k++]= arr2[j++];
            }
        }

        if (i==m){
            while(j<n)  ans[k++]= arr2[j++];
        }
        else{
            while(i<m)  ans[k++]= arr1[i++];
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr1[]= {2,5,7};
        int arr2[]= {3,4,9};

        int ans[]=SortSortedArray(arr1, arr2);

        System.out.println("After Sorting:");
        for(int a: ans) System.out.print(a+ "-->");
        System.out.println("NULL");
    }
}
