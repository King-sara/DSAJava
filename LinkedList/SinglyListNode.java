package LinkedList;

public class SinglyListNode{
    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode (int data){
            this.data=data;
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

    public int length(){
        if (head==null)
            return 0;
        int count=0;
        ListNode temp= head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    public void InsertFirst(int value){
        ListNode newNode= new ListNode(value);
        newNode.next=head;
        head=newNode;
    }

    public void InsertIntermediate(int pos, int value){
        ListNode newNode= new ListNode(value);
        if (pos==1){
            newNode.next=head;
            head=newNode;
            return;
        }
        else{
            ListNode temp=head;
            int count=1;
            while(count<pos-1){
                temp=temp.next;
                count++;
            }
            ListNode current= temp.next;
            newNode.next=current;
            temp.next=newNode;
        }
    }

    public void InsertLast(int value){
        ListNode newNode= new ListNode(value);
        if (head==null)
            head=newNode;
        else{
            ListNode temp=head;
            while(temp.next!=null)
                temp=temp.next;
            temp.next=newNode;
        }
    }

    public ListNode DeleteFirst(){
        if (head==null)
            return null;
        else{
            ListNode temp= head;
            head=head.next;
            temp.next=null;
            return temp;
        }
    }

    public ListNode DeleteIntermediate(int pos){
        if (pos==1){
            ListNode temp=head;
            head=head.next;
            temp.next=null;
            return temp;
        }
        else{
            ListNode temp=head;
            int count=1;
            while(count<pos-1){
                temp=temp.next;
                count+=1;
            }

            ListNode newTemp= temp.next;
            temp.next=newTemp.next;
            newTemp.next=null;
            return newTemp;
        }
    }

    public ListNode DeleteLast(){
        if (head==null)
            return null;
        else if (head.next==null)
            return head;
        else{
            ListNode prev=null;
            ListNode current=head;
            while(current.next!=null){
                prev=current;
                current=current.next;
            }

            prev.next=null;
            return current;
        }
    }

    public boolean search(int key){
        ListNode temp=head;
        while(temp!=null){
            if (temp.data==key)
                return true;
            temp=temp.next;
        }
        return false;
    }

    public ListNode ReverseList(){
        ListNode current=head;
        ListNode next=null;
        ListNode prev=null;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        head=prev;
        return prev;
    }

    public static void main(String[] args) {
        SinglyListNode sll= new SinglyListNode();
        sll.head= new ListNode(10);
        ListNode second= new ListNode(9);
        ListNode third= new ListNode(8);
        ListNode fourth= new ListNode(7);

        sll.head.next=second;
        second.next=third;
        third.next=fourth;

        System.out.println("Length of the Linked List is: "+sll.length());
        sll.display();

        System.out.println("Inserting at the first: ");
        sll.InsertFirst(11);
        sll.display();

        System.out.println("Inserting at an intermediate part:");
        sll.InsertIntermediate(1,12);
        sll.display();

        System.out.println("Inserting at an intermediate part:");
        int length= sll.length();
        System.out.println("Length before insertion: "+ length);
        sll.InsertIntermediate(length+1,6);
        sll.display();

        System.out.println("Inserting at the last: ");
        sll.InsertLast(5);
        sll.display();

        System.out.println("Deleting First element:");
        ListNode temp= sll.DeleteFirst();
        System.out.println("Deleted element is: "+ temp.data);
        sll.display();

        System.out.println("Deleting last element:");
        temp=sll.DeleteLast();
        System.out.println("Deleted element is: "+ temp.data);
        sll.display();

        System.out.println("Deleting Intermediate Element:");
        temp=sll.DeleteIntermediate(1);
        System.out.println("Deleted element is: "+ temp.data);
        sll.display();

        System.out.println("Deleting Intermediate element:");
        length= sll.length();
        System.out.println("Length before insertion: "+ length);
        temp=sll.DeleteIntermediate(length);
        System.out.println("Deleted element is: "+ temp.data);
        sll.display();

        System.out.println("Searching:");
        System.out.println(sll.search(7)?"Element is found":"Element is not found");

        System.out.println("Reversing a Linked List:");
        temp=sll.ReverseList();
        System.out.println("After reversing head element has: "+ temp.data);
        sll.display();
    }
}