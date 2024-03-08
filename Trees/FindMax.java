package Trees;

public class FindMax {
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

    public int MaximumElement(TreeNode root){
        if (root==null) return Integer.MIN_VALUE;
        int result= root.data;

        int left= MaximumElement(root.left);
        int right= MaximumElement(root.right);

        if (left>result)    result=left;
        if (right>result)   result=right;

        return result;
    }

    public void RInOrder(TreeNode root){
        if (root==null) return;
        RInOrder(root.left);
        System.out.print(root.data+ " -->");
        RInOrder(root.right);
    }

    public static void main(String[] args) {
        FindMax tree= new FindMax();
        tree.CreateBinTree();
        System.out.println("Printng tree elemenets:");
        tree.RInOrder(tree.root);
        System.out.println("NULL");

        int max=tree.MaximumElement(tree.root);
        System.out.println("The Maximum element in the tree is: " + max);
    }
}
