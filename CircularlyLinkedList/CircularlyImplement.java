package CircularlyLinkedList;

import java.util.NoSuchElementException;

public class CircularlyImplement {
    private ListNode tail;

    private static class ListNode{
        private int data;
        private ListNode next;

        // ListNode(){
        //     this.data=0;
        //     this.prev=null;
        //     this.next=null;
        // }

        ListNode (int value){
            this.data=value;
            this.next=null;
        }
    }

    public void display(){
        System.out.println("The elements are:");
        ListNode temp=tail.next;
        while(temp!=tail){
            System.out.print(temp.data+ "---> ");
            temp=temp.next;
        }
        System.out.println(temp.data+ "---> NULL");
    }

    public boolean isEmpty(){
        return tail==null?true:false;
    }

    public int count(){
        ListNode temp= tail.next;
        int length=1;
        while(temp!=tail){
            temp=temp.next;
            length++;
        }

        return length;
    }

    public void InsertFirst(int value){
        ListNode temp= new ListNode(value);

        if (tail== null){
            tail=temp;
            tail.next=temp;
        }
        else{
            temp.next=tail.next;
            tail.next=temp;
        }
    }

    public void InsertLast(int value){
        ListNode temp= new ListNode(value);
        if (tail== null){
            tail=temp;
            tail.next=temp;
        }
        else{
            temp.next=tail.next;
            tail.next=temp;
            tail=temp;
        }
    }

    public ListNode DeleteFirst(){
        if (isEmpty())  throw new NoSuchElementException();
        ListNode temp=tail.next;

        if (tail== tail.next){
            tail=null;
        }
        else{
            tail.next=temp.next;
            temp.next=null;
        }

        return temp;
    }

    public  ListNode CreateCircularyList(){
        ListNode first= new ListNode(10);
        ListNode second= new ListNode(9);
        ListNode third= new ListNode(8);
        ListNode forth= new ListNode(7);
        ListNode fifth= new ListNode(6);

        first.next=second;
        second.next=third;
        third.next=forth;
        forth.next=fifth;
        fifth.next=first;
        
        return fifth;
    }

    public static void main(String[] args) {
        CircularlyImplement sll= new CircularlyImplement();
        sll.tail=sll.CreateCircularyList();
        sll.display();
        System.out.println("The number of elements in the list are: "+ sll.count());

        System.out.println("Inserting element to the front:");
        sll.InsertFirst(11);
        System.out.println("After Inserting:");
        sll.display();

        System.out.println("Inserting element to the last: ");
        sll.InsertLast(5);
        System.out.println("After Inserting:");
        sll.display();

        System.out.println("Deleting the first element in the list:");
        System.out.println("For empty Objects:");
        CircularlyImplement emp= new CircularlyImplement();
        ListNode eg=emp.DeleteFirst();
        System.out.println("Empty obj returns: "+ eg);

        System.out.println("For non-empty Objects:");
        ListNode temp=sll.DeleteFirst();
        System.out.println("The deleted element is: "+ temp.data);
        System.out.println("The elements after deleting are:");
        sll.display();

    }
}
