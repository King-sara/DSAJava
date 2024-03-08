import java.util.EmptyStackException;

public class StackImplement{
    private ListNode top;
    private int length;
    
    private static class ListNode{
        private int data;
        private ListNode next;

        ListNode(int value){
            this.data=value;
            this.next=null;
        }
    }

    StackImplement(){
        top=null;
        length=0;
    }

    public int count(){
        return length;
    }

    public boolean isEmpty(){
        return top==null?true:false;
    }

    public void push(int value){
        ListNode temp= new ListNode(value);
        length++;

        temp.next=top;
        top=temp;
    }

    public ListNode pop(){
        if (isEmpty())  throw new EmptyStackException();
        ListNode temp=top;
        top=top.next;
        temp.next=null;
        length--;

        return temp;
    }

    public int peek(){
        if (isEmpty())  throw new EmptyStackException();
        int element= top.data;
        return element;
    }

    public void display(){
        System.out.println("The elements in the stack are:");
        ListNode temp=top;
        while(temp.next!=null){
            System.out.print(temp.data+ "---> ");
            temp=temp.next;
        }
        System.out.println(temp.data+ "---> NULL");
    }

    public static void main(String[] args) {
        StackImplement sll= new StackImplement();

        sll.push(6);
        sll.push(7);
        sll.push(8);
        sll.push(9);
        sll.push(10);

        System.out.println("After pushing elements into the stack");
        sll.display();

        System.out.println("The no. of elements are: "+ sll.count());
        System.out.println("By using the variable length: "+ sll.length);

        ListNode temp= sll.pop();
        System.out.println("The popped element is: "+ temp.data);
        sll.display();

        System.out.println("The top most element in the stack is:");
        System.out.println("Using top variable: "+ sll.top.data);
        System.out.println("Using peek method: "+ sll.peek());

    }
}