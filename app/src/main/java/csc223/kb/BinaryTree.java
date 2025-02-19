package csc223.kb;

public class BinaryTree implements Tree {
    private TreeNode root;
    private int size;
    
    public BinaryTree(){
        this.root = null;
        this.size = 0;
    }

    public String levelorder(){
        if (root == null){
            return "";
        }

        String result = "";
        TreeQueue queue = new TreeQueue();

        queue.enqueue(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.dequeue();
            result += node.data;
            if (node.left != null) queue.enqueue(node.left);
            if (node.right != null) queue.enqueue(node.right);
        }
        return result;
    
    }

    public String preorder() {
        String result = "";
        return preorderHelper(root, result);
    }

    private String preorderHelper(TreeNode node, String result) {
        if (node == null){ 
            return result;
        }

        result += node.data;
        result = preorderHelper(node.left, result);
        result = preorderHelper(node.right, result);

        return result;
    }

    public String inorder() {
        String result = "";
        return inorderHelper(root, result);
    }

    private String inorderHelper(TreeNode node, String result) {
        if (node == null){ 
            return result;
        }

        result = inorderHelper(node.left, result);
        result += node.data;
        result = inorderHelper(node.right, result);
        return result;
    }

    public String postorder() {
        String result = "";
        return postorderHelper(root, result);
    }

    private String postorderHelper(TreeNode node, String result) {
        if (node == null){ 
            return result;
        }

        result = postorderHelper(node.left, result);
        result = postorderHelper(node.right, result);
        result += node.data;
        return result;
    }

    public void insert(char item) {
        TreeNode newNode = new TreeNode(item);

        if (root == null) {
            root = newNode;
        } 
        else {
            TreeQueue queue = new TreeQueue();
            queue.enqueue(root);

            boolean inserted = false;
            while (!queue.isEmpty() && !inserted) {
                TreeNode node = queue.dequeue();

                if (node.left == null) {
                    node.left = newNode;
                    inserted = true;
                } 
                else {
                    queue.enqueue(node.left);
                }

                if (!inserted && node.right == null) {
                    node.right = newNode;
                    inserted = true;
                } 
                else if (!inserted) {
                    queue.enqueue(node.right);
                }
            }
        }
        size++;
    }

    public boolean search(char item) {
        if (root == null) {
            return false;
        }
        TreeQueue queue = new TreeQueue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            if (node.data == item) return true;
            if (node.left != null) queue.enqueue(node.left);
            if (node.right != null) queue.enqueue(node.right);
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int height() {
        return heightHelper(root);
    }

    private int heightHelper(TreeNode node) {
        if (node == null){ 
            return 0;
        }
        return 1 + Math.max(heightHelper(node.left), heightHelper(node.right));
    }  
    
}
