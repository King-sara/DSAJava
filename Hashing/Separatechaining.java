package Hashing;

public class Separatechaining {
    int size;
    int noOfBuckets;
    hashNode[] buckets;

    public Separatechaining(int capacity){
        this.noOfBuckets= capacity;
        buckets= new hashNode[capacity];
    }

    public class hashNode{
        Integer key;
        String value;
        hashNode next;

        public hashNode(Integer key, String val){
            this.key= key;
            this.value= val;
        }
    }

    public int getElementByIndex(Integer key){
        return key%10;  //Modular Hashing Function.
    }

    //PUT:
    public void put(Integer key, String value){
        int index= getElementByIndex(key);

        hashNode head= buckets[index];
        while(head!=null){
            if (head.key.equals(key)){
                head.value= value;
                return;
            }
            head= head.next;
        }

        hashNode temp= new hashNode(key, value);
        size++;
        head= buckets[index];
        temp.next= head;
        buckets[index]= temp;
    }

    public String get(Integer key){
        int index= getElementByIndex(key);
        hashNode head= buckets[index];

        while(head!=null){
            if (head.key.equals(key))   break;
            head= head.next;
        }

        if (head!=null) return head.value;
        return null;
    }

    public String remove(Integer key){
        int index= getElementByIndex(key);

        hashNode prev= null;
        hashNode head= buckets[index];

        while(head!=null){
            if (head.key.equals(key))    break;
            prev= head;
            head= head.next;
        }

        if (head==null) return null;
        if(prev!=null){
            prev.next= head.next;
        }
        else{
            buckets[index]= head.next;
        }
        size--;
        return head.value;
    }

    public void printHashtable(){
        for(int i=0;i<buckets.length;i++){
            System.out.print(i+ ":");
            hashNode head= buckets[i];
            while(head!=null){
                System.out.print(head.key+ ": "+ head.value+ "\t");
                head= head.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Implement Hashing wiht Separate Chaining:");
        Separatechaining obj1= new Separatechaining(10);
         obj1.put(1, "Alester");
         obj1.put(4, "ArulSelvan");
         obj1.put(40, "Saravanan");
         obj1.put(21, "KapilAdhithya");
         obj1.put(48, "Sudharsan kumar");

        obj1.printHashtable();
        obj1.put(42, "Shree Harish");

        System.out.println("Performing Get opertion:");
        String value1= obj1.get(42);
        String value2= obj1.get(3);

        System.out.println("For 42: "+ value1+ " For 2:"+ value2);

        System.out.println("Deleting a Node from the hashTable");
        obj1.remove(40);
        System.out.println("After removing 40 from the hashTable");
        obj1.printHashtable();
    }
}