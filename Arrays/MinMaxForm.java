package Arrays;

public class MinMaxForm {
    void SortInMinMax(int arr[]){
        int maxInd= arr.length-1;
        int minInd= 0;
        for(int i=0;i<arr.length;i++){
            if (i%2==0){
                arr[i]= arr[i]+ (arr[maxInd]%10)*10;
                maxInd--;
            }
            else{
                arr[i]= arr[i]+(arr[minInd]%10)*10;
                minInd++;
            }
        }

        for(int i=0;i<arr.length;i++)    arr[i]/=10;
    }
    public static void main(String[] args) {
        int arr[]= new int[] {2,3,5,6,8,9};
        MinMaxForm obj1= new MinMaxForm();
        obj1.SortInMinMax(arr);
        
        System.out.println("After sorting: ");
        for(int i=0;i<arr.length;i++)   System.out.print(arr[i]+ "-->");
        System.out.println("NULL");
    }
}
