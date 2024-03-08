package LinkedList;

public class InsertIntoSSLL {
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

    public void Insert(int key){
        ListNode newNode= new ListNode(key);
        ListNode temp= head;
        ListNode curr=null;

        while(temp!=null && temp.data<key){
            curr=temp;
            temp=temp.next;
        }

        if (temp==null){
            if (curr.data<key){
                curr.next=newNode;
            }
            return;
        }
        else{
            curr.next=newNode;
            newNode.next=temp;
        }
    }

    public static void main(String[] args) {
        InsertIntoSSLL sll= new InsertIntoSSLL();
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

        sll.Insert(12);
        System.out.println("After Inserting the key:");
        sll.display();
    }
}
