package LinkedList;

public class RemoveDuplicateFromSSLL {
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
        ListNode current= head;
        while(current!=null){
            System.out.print(current.data+ "-->");
            current=current.next;
        }
        System.out.println("NULL");
    }

    public void AvoidDuplicate(){
        ListNode temp=head;

        while(temp!=null && temp.next!=null){
            if (temp.data==temp.next.data){
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;
            }
        }
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSSLL sll= new RemoveDuplicateFromSSLL();

        sll.head= new ListNode(1);
        ListNode second= new ListNode(1);
        ListNode third= new ListNode(2);
        ListNode forth= new ListNode(3);
        ListNode fifth= new ListNode(3);

        sll.head.next=second;
        second.next=third;
        third.next=forth;
        forth.next=fifth;

        sll.display();

        sll.AvoidDuplicate();
        System.out.println("Removed Duplicate elements:\n");
        sll.display();
    }
}
