package LinkedList;

public class FloydsCycle {
    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
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

    private void RemoveLoop(){
        ListNode slowptr= head;
        ListNode fastptr= head;

        while(fastptr.next!=null && fastptr!=null){
            fastptr= fastptr.next.next;
            slowptr= slowptr.next;

            if (fastptr.next==slowptr.next){
                break;
            }
        }

        ListNode temp=head;
        while(temp.next!=slowptr.next){
            temp=temp.next;
            slowptr=slowptr.next;
        }
        slowptr.next=null;
    }

    private ListNode FirstLoopEntry(){
        ListNode slowptr= head;
        ListNode fastptr= head;

        while(fastptr.next!=null && fastptr!=null){
            fastptr= fastptr.next.next;
            slowptr= slowptr.next;

            if (fastptr==slowptr){
                break;
            }
        }

        ListNode temp= head;
        while(temp!=slowptr){
            temp=temp.next.next;
            slowptr=slowptr.next;
        }

        return temp;
    }

    public boolean CycleDetection(){
        ListNode slowptr= head;
        ListNode fastptr= head;

        while(fastptr.next!=null && fastptr!=null){
            fastptr= fastptr.next.next;
            slowptr= slowptr.next;

            if (fastptr==slowptr){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FloydsCycle sll= new FloydsCycle();

        sll.head= new ListNode(1);
        ListNode second= new ListNode(3);
        ListNode third= new ListNode(7);
        ListNode forth= new ListNode(10);
        ListNode fifth= new ListNode(16);

        sll.head.next=second;
        second.next=third;
        third.next=forth;
        forth.next=fifth;
        fifth.next=third;

        // sll.display();  Due to presence of cycle, it keeps running.. So, DON'T.

        System.out.println(sll.CycleDetection()? "Yes, there is a loop in the list" : "No, there is no loop in the list");

        ListNode temp= sll.FirstLoopEntry();
        System.out.println("The First Entry in the loop is: "+ temp.data);

        System.out.println("Removing Loop from the SinglyLinkedList");
        sll.RemoveLoop();
        System.out.println("Now, the elements in the list are:");
        sll.display();
    }
}
