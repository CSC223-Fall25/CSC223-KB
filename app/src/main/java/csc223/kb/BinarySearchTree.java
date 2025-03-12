package csc223.kb;

public class BinarySearchTree {
    private TreeNode root;


    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private TreeNode insertHelper(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.value) {
            node.left = insertHelper(node.left, value);
        } 
        
        else if (value > node.value) {
            node.right = insertHelper(node.right, value);
        }

        return node;
    }


    public void delete(int value) {
        root = deleteHelper(root, value);
    }

    private TreeNode deleteHelper(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = deleteHelper(node.left, value);
        } 
        
        else if (value > node.value) {
            node.right = deleteHelper(node.right, value);
        } 
        
        else {
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            TreeNode minNode = findMin(node.right);
            node.value = minNode.value;
            node.right = deleteHelper(node.right, minNode.value);
        }

        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public boolean search(int value) {
        return searchHelper(root, value);
    }

    private boolean searchHelper(TreeNode node, int value) {
        if (node == null) {
            return false;
        }

        if (node.value == value) {
            return true;
        }

        if (value < node.value) {
            return searchHelper(node.left, value);
        } else {
            return searchHelper(node.right, value);
        }
    }

    public void update(int oldValue, int newValue) {
        if (search(oldValue)) {
            delete(oldValue);
            insert(newValue);
        }
    }

    public String inOrder() {
        return inOrderHelper(root).trim();
    }

    private String inOrderHelper(TreeNode node) {
        if (node == null) {
            return "";
        }

        return inOrderHelper(node.left) + node.value + " " + inOrderHelper(node.right);
    }

    public void sortedArrayToBST(int[] values) {
        root = sortedArrayToBSTHelper(values, 0, values.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] values, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(values[mid]);

        node.left = sortedArrayToBSTHelper(values, left, mid - 1);
        node.right = sortedArrayToBSTHelper(values, mid + 1, right);

        return node;
    }

    public int lowestCommonAncestor(int p, int q) {
        // Ensure both p and q exist in the tree
        if (!search(p) || !search(q)) {
            return -1; // If either p or q is missing, return -1
        }
    
        return lowestCommonAncestorHelper(root, p, q);
    }
    
    private int lowestCommonAncestorHelper(TreeNode node, int p, int q) {
        if (node == null) {
            return -1;
        }
    
        if (node.value > p && node.value > q) {
            return lowestCommonAncestorHelper(node.left, p, q);
        } 
        
        else if (node.value < p && node.value < q) {
            return lowestCommonAncestorHelper(node.right, p, q);
        } 
        
        else {
            return node.value; // Found the lowest common ancestor
        }
    }
    
}
