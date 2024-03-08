package LinkedList;

public class MiddleNode {
    private ListNode head;

    private static class ListNode{ //static keyword is important..
        private int data;
        private ListNode next;

        public ListNode (int val){
            this.data=val;
            this.next=null;
        }
    }

    public void display(){
        ListNode temp=head;

        while(temp!=null){
            System.out.print(temp.data + " --->");
            temp=temp.next;
        }
        System.out.print("NULL");
        System.out.println("");
    }

    public ListNode Middle(){

        //If Even no. of nodes return right most...
        ListNode slowptr=head;
        ListNode fastptr=head;

        while(fastptr!=null && fastptr.next!=null){
            fastptr=fastptr.next.next;
            slowptr=slowptr.next;
        }

        return slowptr;
    }

    public static void main(String args[]){
        MiddleNode sll= new MiddleNode();
        sll.head= new ListNode(10);
        ListNode second= new ListNode(9);
        ListNode third= new ListNode(8);
        ListNode forth= new ListNode(7);
        ListNode fifth= new ListNode(6);

        sll.head.next=second;
        second.next=third;
        third.next=forth;
        forth.next=fifth;

        sll.display();

        ListNode temp=sll.Middle();
        System.out.println("Middle element is : "+ temp.data);
    }

}
