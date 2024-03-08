package Arrays;

public class RemoveInteger {
    
    public static void printArray(int[] array){
        int n=array.length;
        for(int i=0;i<n;i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }

    public static int[] removeEven(int[] array){ //static methods can be called without obj instantiation
        int oddCount=0;
        for(int i=0;i<array.length;i++){
            if (array[i]%2!=0)
                oddCount+=1;
        }

        int new_array[]= new int[oddCount];
        int index=0;
        for(int i=0;i<array.length;i++){
            if (array[i]%2!=0){
                new_array[index]=array[i];
                index++;
            }
        }

        return new_array;
    }

    public static void main(String[] args) {
        int ans[]= removeEven(new int[] {1,2,3,4,5,6,7,8,9,10});

        printArray(ans); //static ref. to static method. So, printArray should be static.
    }
}
