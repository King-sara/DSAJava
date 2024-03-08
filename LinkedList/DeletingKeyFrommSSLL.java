package LinkedList;

public class DeletingKeyFrommSSLL {
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

    public void delete(int key){
        ListNode temp=head;
        ListNode curr= null;

        while(temp!=null && temp.data!=key){
            curr=temp;
            temp=temp.next;
        }

        if (temp==null) return;
        else{
            curr.next=temp.next;
        }

    }
    public static void main(String[] args) {
        DeletingKeyFrommSSLL sll= new DeletingKeyFrommSSLL();
        sll.head= new ListNode(1);
        ListNode second= new ListNode(3);
        ListNode third= new ListNode(7);
        ListNode forth= new ListNode(10);
        ListNode fifth= new ListNode(16);

        sll.head.next=second;
        second.next=third;
        third.next=forth;
        forth.next=fifth;

        sll.display();

        sll.delete(16);
        System.out.println("After deleting: ");
        sll.display();
    }
}
