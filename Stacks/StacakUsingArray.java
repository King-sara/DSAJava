public class StacakUsingArray {
    private int top;
    private int length;
    private int[] arr;

    StacakUsingArray(int capacity){
        this.top=-1;
        this.length=0;
        this.arr= new int[capacity];
    }

    public boolean isEmpty(){
        return top<0;
    }

    public boolean isFull(){
        return top+1==arr.length;
    }

    public int count(){
        return length;
    }

    public void push(int val){
        if (isFull()) throw new RuntimeException("Stack is Full..");
        top++;
        length++;
        arr[top]=val;
    }

    public int pop(){
        if (isEmpty()) throw new RuntimeException("Stack is Empty..");
        int temp=arr[top];
        top--;
        length--;

        return temp;
    }

    public int peek(){
        if (isEmpty())  throw new RuntimeException("Stack is Empty..");
        return arr[top];
    }

    public void display(){
        System.out.println("The elements in the array are: ");
        int i=top;
        System.out.print("END ");
        while(i>=0){
            System.out.print(" <---"+ arr[i]);
            i--;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        StacakUsingArray sll= new StacakUsingArray(3);

        System.out.println("Pushing the elements into the array:");
        sll.push(10);
        sll.push(9);
        sll.push(8);
        // sll.push(7);

        System.out.println("The elements pushed are:");
        sll.display();
        System.out.println("Its length is: "+ sll.count());

        System.out.println("After popping, the element is: "+ sll.pop());
        System.out.println("Displaying after pop");
        sll.display();

        System.out.println("The peek element is: "+ sll.peek());
    }
}
