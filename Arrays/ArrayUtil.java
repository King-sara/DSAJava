//Create, Add, Update Array:

package Arrays; //!Important

public class ArrayUtil{  //Existing package that handles Null input operation in Array

    public void printArray(int arr[]){ //print Array Elements
        int n= arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public void arrayDemo(){
        int array[]= new int[5];
        printArray(array); //Prints default value as [0,0,0,0,0]

        array[0]=1;
        array[1]=2;
        array[2]=3;
        array[3]=4;
        array[4]=5;
        array[2]=6; //Updates the data
        array[5]=10; //outOfBound Error
        printArray(array);

        System.out.println(array.length); //Length method in Array
        System.out.println(array[array.length -1]);

        int new_array[]={10,9,8,7};
        printArray(new_array);
    }

    public static void main(String args[]){
        ArrayUtil arrayutil = new ArrayUtil(); //Object creation
        arrayutil.arrayDemo();

        arrayutil.printArray(new int[] {10,20,30,40,50}); //Another NEW technique..
    }
}