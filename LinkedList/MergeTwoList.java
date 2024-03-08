package LinkedList;

public class MergeTwoList {
    // private ListNode head;

    private static class ListNode{ //static keyword is important..
        private int data;
        private ListNode next;

        public ListNode (int val){
            this.data=val;
            this.next=null;
        }
    }

    public void display(ListNode head){
        ListNode temp=head;

        while(temp!=null){
            System.out.print(temp.data + " --->");
            temp=temp.next;
        }
        System.out.print("NULL");
        System.out.println("");
    }

    public static ListNode MergeNode(ListNode head1, ListNode head2){
        ListNode dummy= new ListNode(0);
        ListNode temp1=head1;
        ListNode temp2= head2;

        ListNode temp=dummy;

        while(temp1!=null && temp2!=null){
            if (temp1.data<temp2.data){
                temp.next=temp1;
                temp1=temp1.next;
            }

            else{
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }

        if (temp1==null)
            temp.next=temp2;
        else
            temp.next=temp1;

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoList sll= new MergeTwoList();
        ListNode sll_head= new ListNode(1);
        ListNode second= new ListNode(5);
        ListNode third= new ListNode(6);
        ListNode forth= new ListNode(9);
        ListNode fifth= new ListNode(11);

        sll_head.next=second;
        second.next=third;
        third.next=forth;
        forth.next=fifth;

        sll.display(sll_head);

        MergeTwoList smm= new MergeTwoList();
        ListNode smm_head= new ListNode(2);
        ListNode smm_second= new ListNode(4);
        ListNode smm_third= new ListNode(6);
        ListNode smm_forth= new ListNode(12);
        ListNode smm_fifth= new ListNode(15);

        smm_head.next=smm_second;
        smm_second.next=smm_third;
        smm_third.next=smm_forth;
        smm_forth.next=smm_fifth;

        smm.display(smm_head);

        ListNode temp= MergeNode(sll_head, smm_head);

        sll.display(temp);
    }
}
