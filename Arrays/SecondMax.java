package Arrays;

public class SecondMax {
    public int findSecondMax(int[] arr){
        int max= Integer.MIN_VALUE;
        int SecondMax= Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if (arr[i]>max){
                SecondMax=max;
                max=arr[i];
            }

            else if (arr[i]>SecondMax)
                SecondMax=arr[i];
        }

        System.out.println("First maximum element is: "+ max);
        return SecondMax;
    }

    public static void main(String[] args) {
        SecondMax maxima = new SecondMax();
        int[] arr= {13,34,2,34,33,1};

        System.out.println("Second maximum element is: "+ maxima.findSecondMax(arr));
    }
}
