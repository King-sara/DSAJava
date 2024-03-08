package Trees;

public class BSearchTree {
    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data=data;
        }
    }

    public void RInOrder(TreeNode root){
        if (root==null) return;
        RInOrder(root.left);
        // System.out.print("NULL --->");
        System.out.print(root.data+ " --->");
        RInOrder(root.right);
        // System.out.print("NULL --->");
    }

    public TreeNode InsertBST(TreeNode root, int value){
        TreeNode temp= new TreeNode(value);
        if (root==null){
            root=temp;
            return root;
        }
        else if (value>root.data)   root.right=InsertBST(root.right, value);
        else if (value<root.data)   root.left=InsertBST(root.left, value);

        return root;
    }

    public TreeNode search(TreeNode root, int key){
        if (root==null || root.data==key) return root;
        if (key>root.data)  return search(root.right, key);
        if (key<root.data)  return search(root.left, key);
        
        return null;
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
        BSearchTree tree= new BSearchTree();
        int n=5;
        System.out.println("Creating BST:");
        for(int i=0;i<n;i++){
            tree.root=tree.InsertBST(tree.root, i+1);
        }
        System.out.println("Displaying BST elements:");
        tree.RInOrder(tree.root);
        System.out.println("NULL");

        System.out.println("Searching in BST:");
        TreeNode temp=tree.search(tree.root, 14);
        System.out.println(temp==null? "Not Found": "Found: "+ temp.data);

        System.out.println("Validating BST:");
        System.out.println(tree.validate(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE)==true? "It is a valid tree": "It is an invalid tree");
    }
}
