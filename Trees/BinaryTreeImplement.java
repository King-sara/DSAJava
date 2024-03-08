package Trees;

import java.util.*;

public class BinaryTreeImplement {
    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private int data;
        private TreeNode right;

        public TreeNode(int data){
            this.data=data;
        }
    }

    public void CreateBinTree(){
        TreeNode first= new TreeNode(1);
        TreeNode second= new TreeNode(2);
        TreeNode third= new TreeNode(3);
        TreeNode fourth= new TreeNode(4);
        TreeNode fifth= new TreeNode(5);

        root=first;
        first.left=second;
        first.right=third;
        second.left=fourth;
        second.right=fifth;
    }

    public void RPreOrder(TreeNode root){
        if (root==null) return;
        System.out.print(root.data+ " -->");
        RPreOrder(root.left);
        RPreOrder(root.right);
    }

    public void IPreOrder(TreeNode root){
        TreeNode temp=root;

        if (temp==null) return;
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp1= stack.pop();
            System.out.print(temp1.data+ " -->");
            if (temp1.right!=null)  stack.push(temp1.right);
            if (temp1.left!=null)   stack.push(temp1.left);
        }
    }

    public void RInOrder(TreeNode root){
        if (root==null) return;
        RInOrder(root.left);
        System.out.print(root.data+ " -->");
        RInOrder(root.right);
    }

    public void IInOrder(TreeNode root){
        if (root==null) return;
        Stack<TreeNode> stack= new Stack<>();
        TreeNode temp=root;

        while(!stack.isEmpty() || temp!=null){
            if (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            else{
                temp= stack.pop();
                System.out.print(temp.data+ " --->");
                temp=temp.right;
            }
        }
    }

    public void RPostOrder(TreeNode root){
        if (root==null) return;
        RPostOrder(root.left);
        RPostOrder(root.right);
        System.out.print(root.data+ " --->");
    }

    public void IPostOrder(TreeNode root){
        if (root==null) return;

        Stack<TreeNode> stack= new Stack<>();
        TreeNode temp= root;
        while(!stack.isEmpty() || temp!=null){
            if (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            else{
                TreeNode temp1= stack.peek().right;
                if (temp1 ==null){
                    temp1= stack.pop();
                    System.out.print(temp1.data+ "--->");
                    while(!stack.isEmpty() && temp1==stack.peek().right){
                        temp1=stack.pop();
                        System.out.print(temp1.data+ " -->");
                    }
                }

                else{
                    temp=temp1;
                }
            }
        }
    }

    public void LevelOrder(TreeNode root){
        if (root==null) return;

        TreeNode temp=root;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(temp);
        while(!queue.isEmpty()){
            temp= queue.poll();
            System.out.print(temp.data+ " --->");
            if (temp.left!=null)    queue.offer(temp.left);
            if (temp.right!=null)   queue.offer(temp.right);
        }
        System.out.println("NULL");
    }

    public boolean validate(TreeNode root, int min, int max){
        if (root==null) return true;
        if (root.data>max || root.data<min) return false;

        boolean left= validate(root.left, min, root.data);
        if (left){
            boolean right= validate(root.right, root.data, max);
            return right;
        }

        return left;
    }

    public static void main(String[] args) {
        BinaryTreeImplement bintree= new BinaryTreeImplement();
        bintree.CreateBinTree();

        System.out.println("Implementing Recursive Pre Order traversal:");
        bintree.RPreOrder(bintree.root);
        System.out.println("NULL");

        System.out.println("Implementing Iterative Pre Order Traversal:");
        bintree.IPreOrder(bintree.root);
        System.out.println("NULL");

        System.out.println("Implementing Recursive In Order traversal:");
        bintree.RInOrder(bintree.root);
        System.out.println("NULL");

        System.out.println("Implementing Iterative In Order Traversal:");
        bintree.IInOrder(bintree.root);
        System.out.println("NULL");

        System.out.println("Implementing Recursive Post Order traversal:");
        bintree.RPostOrder(bintree.root);
        System.out.println("NULL");

        System.out.println("Implementing Iterative Post Order Traversal:");
        bintree.IPostOrder(bintree.root);
        System.out.println("NULL");

        System.out.println("Implementing Level Order Traversal:");
        bintree.LevelOrder(bintree.root);

        System.out.println("Validating BST:");
        System.out.println(bintree.validate(bintree.root, Integer.MIN_VALUE, Integer.MAX_VALUE)==true? "It is a valid tree": "It is an invalid tree");
    }
}
