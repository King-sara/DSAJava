package Queue;

import java.util.NoSuchElementException;

public class QueueIMplement {
    private ListNode front;
    private ListNode rear;
    private int length;

    QueueIMplement(){
        front=null;
        rear=null;
        length=0;
    }

    public int length() {return length;}

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode (int data){
            this.data=data;
            this.next=null;
        }
    }

    public boolean isEmpty()    {return length==0;}

    public void enqueue(int data){
        ListNode temp= new ListNode(data);
        if (isEmpty())  {front=temp;}
        else{rear.next=temp;}
        rear=temp;
        length++;
    }

    public int dequeue(){
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp=front.data;
        front=front.next;
        if (front==null)    rear=null;
        length--;
        return temp;
    }

    public void display(){
        ListNode temp=front;
        System.out.println("The elements are:");
        while(temp!=null){
            System.out.print(temp.data+ "-->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }

    public int first(){
        if (isEmpty())  
            throw new NoSuchElementException("Queue is empty");
        return front.data;
    }

    public int last(){
        if (isEmpty())  
            throw new NoSuchElementException("Queue is empty");
        return rear.data;
    }

    public static void main(String[] args) {
        QueueIMplement queue= new QueueIMplement();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        int temp=queue.dequeue();
        System.out.println("Dequeued element is: "+temp);

        queue.display();

        System.out.println("First element in the queue is: "+ queue.first());
        System.out.println("The last element in the queue is: "+ queue.last());
    }

}
