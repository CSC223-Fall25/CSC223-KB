package csc223.kb;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TreeNodeTest {

    @Test
    public void testNodeInitialization() {
        TreeNode node = new TreeNode('A');
        assertNotNull(node);
        assertEquals('A', node.data);
        assertNull(node.left);
        assertNull(node.right);
    }

    @Test
    public void testAssignLeftChild() {
        TreeNode parent = new TreeNode('A');
        TreeNode leftChild = new TreeNode('B');
        parent.left = leftChild;

        assertNotNull(parent.left);
        assertEquals('B', parent.left.data);
    }

    @Test
    public void testAssignRightChild() {
        TreeNode parent = new TreeNode('A');
        TreeNode rightChild = new TreeNode('C');
        parent.right = rightChild;

        assertNotNull(parent.right);
        assertEquals('C', parent.right.data);
    }

    @Test
    public void testTreeStructure() {
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.left.right = new TreeNode('E');

        assertEquals('A', root.data);
        assertEquals('B', root.left.data);
        assertEquals('C', root.right.data);
        assertEquals('D', root.left.left.data);
        assertEquals('E', root.left.right.data);
    }
}
