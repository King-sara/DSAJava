package Graphs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GeneralGraph {
    int[][] AdjMatrix;
    LinkedList<Integer>[] AdjList;

    public GeneralGraph(int nodes){
        this.AdjMatrix= new int[nodes][nodes];
        this.AdjList= new LinkedList[nodes];

        for(int i=0;i<nodes;i++) this.AdjList[i]= new LinkedList<>();
    }

    public void addEdge(int u, int v){
        this.AdjMatrix[u][v]=1;
        this.AdjMatrix[v][u]=1;

        this.AdjList[u].add(v);
        this.AdjList[v].add(u);
    }

    public void BFS(int start, int len){
        boolean[] visited= new boolean[len];
        Queue<Integer> queue= new LinkedList<>();
        visited[start]=true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int temp= queue.poll();
            System.out.print(temp+ " ");
            for(int element: AdjList[temp]){
                if (!visited[element]){
                    visited[element]= true;
                    queue.offer(element);
                }
            }
        }
    }

    public void DFS(int start, int len){
        boolean visited[]= new boolean[len];
        Stack<Integer> stack= new Stack<>();

        stack.push(start);
        while(!stack.isEmpty()){
            int temp= stack.pop();
            if (!visited[temp]){
                visited[temp]=true;
                System.out.print(temp+ " ");
            }
            for(int element: AdjList[temp]){
                if (!visited[element])  stack.push(element);
            }
        }
    }

    public void RecurDFS(int start, boolean visited[]){
        visited[start]=true;
        System.out.print(start+ " ");
        for(int element: AdjList[start]){
            if (!visited[element])  RecurDFS(element, visited);
        }
    }

    public void RecurDFS(int len){
        boolean visited[]= new boolean[len];
        for(int i=0;i<len;i++){
            //for(int j=0;j<len;j++)  System.out.print(visited[i]+ "\t");
            if (!visited[i])    RecurDFS(i, visited);
        }
    }

    public void ConnectedDFS(int len){
        boolean visited[]= new boolean[len];
        int compId[]= new int[len];
        int count=0;
        for(int i=0;i<len;i++){
            if (!visited[i]){
                ConnectednessDFS(i, visited, compId, count);
                count++;
            }
        }

        getConnectedCount(compId);

    }

    public void ConnectednessDFS(int value, boolean[] visited, int[] compId, int count){
            visited[value]= true;
            compId[value]= count;
            System.out.print(value+ " ");
        for(int element: AdjList[value]){
            if (!visited[element])  ConnectednessDFS(element, visited, compId, count);
        }
    }

    public static void getConnectedCount(int compId[]){
        System.out.println("\nSo, the compId of the graphs elements are:");
        for(int i=0;i<compId.length;i++){
            System.out.println(i+ ":\t"+ compId[i]);
        }
    }

    public void printAdjMatrix(){
        for(int[] outer: AdjMatrix){
            for(int element: outer){
                System.out.print(element+ "\t");
            }
            System.out.println();
        }
    }

    public void printAdjList(int nodes){
        for(int i=0;i<nodes;i++){
            System.out.print(i+ ":\t");
            for(int element: AdjList[i])    System.out.print(element+ "\t");
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // int nodes=6;
        int nodes=5;
        GeneralGraph graph= new GeneralGraph(nodes);
        GeneralGraph ConnGraphobj1= new GeneralGraph(nodes+1);

        graph.addEdge(0,1);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        graph.addEdge(3, 0);
        graph.addEdge(2, 4);

        System.out.println("After arrnaging the Matrix:");
        System.out.println("The Adjacency Matrix is:");
        graph.printAdjMatrix();

        System.out.println("And, the Adjacency List is:");
        graph.printAdjList(nodes);

        System.out.println("Breadth- First Search using Queue:");
        graph.BFS(0, nodes);

        System.out.println("\nDepth- First Search using Stack in Iterations:");
        graph.DFS(0, nodes);

        System.out.println("\nExecuting Recursive DFS:");
        graph.RecurDFS(nodes);

        ConnGraphobj1.addEdge(0,1);
        ConnGraphobj1.addEdge(2,1);
        ConnGraphobj1.addEdge(3,4);

        System.out.println("\nChecking the Connected Components in a graph");
        ConnGraphobj1.ConnectedDFS(nodes+1);
    }
}
