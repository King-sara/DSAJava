package DoublyLinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DoublyImplement {
    private ListNode head;
    private ListNode tail;

    private static class ListNode{
        private ListNode prev;
        private int data;
        private ListNode next;

        // ListNode(){
        //     this.data=0;
        //     this.prev=null;
        //     this.next=null;
        // }

        ListNode (int value){
            this.data=value;
            this.prev=null;
            this.next=null;
        }
    }

    public boolean isEmpty(){
        return head==null?true:false;
    }

    public int count(){
        ListNode temp= head;
        int length=1;
        while(temp!=null){
            temp=temp.next;
            length++;
        }

        return length;
    }

    public void displayFromFront(){
        ListNode temp=head;
        System.out.print("NULL--->");

        while(temp!=null){
            System.out.print(temp.data);
            System.out.print("--->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }

    public void displayFromEnd(){
        ListNode temp=tail;
        System.out.print("NULL--->");

        while(temp!=null){
            System.out.print(temp.data);
            System.out.print("--->");
            temp=temp.prev;
        }
        System.out.println("NULL");
    }

    public void InsertFirst(int value){
        ListNode temp= new ListNode(value);

        if (head==null){
            tail=temp;
        }

        else {
            temp.next=head;
            head.prev=temp;
        }
        head=temp;
    }

    public void InsertLast(int value){
        ListNode temp= new ListNode(value);

        if (head==null){
            head=temp;
        }

        else{
            tail.next=temp;
            temp.prev=tail;
        }
        tail=temp;
    }

    public ListNode DeleteFirst(){
        if (isEmpty())  throw new NoSuchElementException();
        ListNode temp=head;
        
        if (head==tail){
            head=null;
            tail=null;
        }

        else{
           head.next.prev=null;
           head=head.next;
           temp.next=null; 
        }
        return temp;
    }

    public ListNode DeleteLast(){
        if (isEmpty())  throw new NoSuchElementException();
        ListNode temp=tail;

        if (head==tail){
            head=null;
            tail=null;
        }

        else{
            tail.prev.next=null;
            tail=tail.prev;
            tail.prev=null;
        }

        return temp;
    }

    public static void main(String[] args) {
        DoublyImplement sll= new DoublyImplement();
        Scanner scan= new Scanner(System.in);
        int element_count, i;

        System.out.println("Executing List creation using Insert at Last method");
        System.out.println("Enter the no. of Elements in the list");
        element_count=scan.nextInt();

        i=0;
        System.out.println("Enter the elements:");
        while(i<element_count){
            int element_value= scan.nextInt();
            sll.InsertLast(element_value);
            i++;
        }

        System.out.println("The elements are:");
        System.out.println("From Head:");
        sll.displayFromFront();

        System.out.println("From Tail:");
        sll.displayFromEnd();

        System.out.println("Enter the no. of elements in the list");
        element_count=scan.nextInt();
        i=0;
        System.out.println("Enter the elements:");
        while(i<element_count){
            int element_value= scan.nextInt();
            sll.InsertFirst(element_value);
            i++;
        }

        System.out.println("The elements are:");
        System.out.println("From Head:");
        sll.displayFromFront();

        System.out.println("From Tail:");
        sll.displayFromEnd();
        scan.close();

        System.out.println("Deleting the First Node");
        ListNode temp= sll.DeleteFirst();
        System.out.println("The first element that is removed is: "+ temp.data);
        System.out.println("Traversing the list from head:");
        sll.displayFromFront();

        System.out.println("Deleting the Last Node");
        temp= sll.DeleteLast();
        System.out.println("So, the last element to be removed is: "+ temp.data);
        System.out.println("Traversing the list from head:");
        sll.displayFromFront();

        scan.close();
    }

}
