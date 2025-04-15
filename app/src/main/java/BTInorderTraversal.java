
 // This method should return a list of integers from the inorder traversal
 public class BTInorderTraversal {
    public List<Integer> inorderTracersal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doInorder(root, result);
        return result;
    }

    //This method does the actual inorder traversal using recursion
    public void doInorder(TreeNode node, List<Integer> result) {
        if(node == null) {
            return;
        }
        doInorder(node.left, result);// Should traverse the left subtree
        result.add(node.value);// Visits the current node
        doInorder(node.right, result);// Should traverse the right subtree
    }
}

// Could potentially use this to define binary tree node
int value;
TreeNode left;
TreeNode right;

TreeNode() {
}

TreeNode(int value) {
    this.value = value;
}

TreeNode(int value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
}
