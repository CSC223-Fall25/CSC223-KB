package csc223.kb;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    char data;
    int value;

    public TreeNode(char data){
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public TreeNode(int value){
        this.left = null;
        this.right = null;
        this.value = value;
    }
    
}
