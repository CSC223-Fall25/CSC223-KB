import java.util.*;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class BTInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // stack will help us go through the tree without using recursion
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        // We keep going as long as there is a node to visit
        while (current != null || !stack.isEmpty()) {

            // Go all the way to the left child, pushing nodes along the way
            while (current != null) {
                stack.push(current);  
                current = current.left; 
            }

            // Now we visit the node at the top of the stack
            current = stack.pop();  
            result.add(current.val);  

            // Now we move to the right child of the node
            current = current.right;
        }

        return result;
    }
}