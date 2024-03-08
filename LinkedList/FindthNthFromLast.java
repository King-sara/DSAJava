package LinkedList;

public class FindthNthFromLast {
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

    public ListNode FindNTh(int pos){

        if (head==null)
            return null;

        if (pos<=0){
            throw new IllegalAccessError("Position out of bound..");
        }

        ListNode mainptr=head;
        ListNode refptr=head;

        int count=0;

        while(count<pos){
            refptr=refptr.next;
            count++;
        }

        while(refptr!=null){
            mainptr=mainptr.next;
            refptr=refptr.next;
        }

        return mainptr;
    }

    public static void main(String[] args) {
        FindthNthFromLast sll= new FindthNthFromLast();
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

        int data=2;
        ListNode temp=sll.FindNTh(data);
        System.out.println("So, the element from the "+data+ " position is: "+ temp.data);
    }
}
