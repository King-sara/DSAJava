package Trees;

public class BinaryHeap {
    Integer[] heap;
    int n;

    public BinaryHeap(int capacity){
        n=0;
        heap= new Integer[capacity+1];
    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }

    public void display(int size){
        for(int i=1;i<=size;i++){
            System.out.print(heap[i] + " --->");
        }
        System.out.println("NULL");
    }

    public void resize(int n){
        Integer[] temp= new Integer[n];
        for(int i=0;i<heap.length;i++)
            temp[i]=heap[i];
        heap=temp;

    }

    public void swap(int i, int j){
        int temp= heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }

    public void swim(int k){
        while(k>1 && heap[k]>heap[k/2]){
            swap(k, k/2);
            k/=2;
        }
    }

    public void insert(int x){
        if (n==heap.length-1)   resize(2*heap.length);
        n++;
        heap[n]=x;
        swim(n);
    }

    private void sink(int k){
        while(2*k<=n){
            int j=2*k;
            if (j<n && heap[j]<heap[j+1])   j++;
            if (heap[k]>heap[j])    break;
            swap(k,j);
            k=j;
        }
    }

    public int delMax(){
        int max= heap[1];
        swap(1,n);
        n--;
        sink(1);
        heap[n+1]=null;

        if (n>0 && n==(heap.length)/4)  resize(heap.length/2);
        return max;
    }
    public static void main(String[] args) {
        BinaryHeap bin= new BinaryHeap(3);
        bin.insert(4);
        bin.insert(5);
        bin.insert(2);
        bin.insert(6);
        bin.insert(1);
        bin.insert(3);
        System.out.println("Size: "+ bin.size());
        bin.display(bin.size());
        System.out.println("Executing max delete method:");
        System.out.println("Maximum element in the heap is: "+ bin.delMax());
        System.out.println("The heap becomes:");
        bin.display(bin.size());
    }
}
