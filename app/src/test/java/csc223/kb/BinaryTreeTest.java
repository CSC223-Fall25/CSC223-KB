package csc223.kb;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testOnEmptyTree() {
        BinaryTree tree = new BinaryTree();

        assertTrue(tree.isEmpty());
        assertEquals("", tree.preorder());
        assertEquals("", tree.inorder());
        assertEquals("", tree.postorder());
        assertEquals("", tree.levelorder());
    }

    @Test
    public void testOnTreeWithOneNode() {
        BinaryTree tree = new BinaryTree();
        tree.insert('A');

        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());
        assertEquals(1, tree.height());

        assertEquals("A", tree.preorder());
        assertEquals("A", tree.inorder());
        assertEquals("A", tree.postorder());
        assertEquals("A", tree.levelorder());
    }

    @Test
    public void testOnTreeWithTwoNodes() {
        BinaryTree tree = new BinaryTree();
        tree.insert('A');
        tree.insert('B');

        assertEquals(2, tree.size());
        assertEquals(2, tree.height());

        assertEquals("AB", tree.preorder());  // Root -> Left
        assertEquals("BA", tree.inorder());   // Left -> Root
        assertEquals("BA", tree.postorder()); // Left -> Root
        assertEquals("AB", tree.levelorder()); // Root -> Left
    }

    @Test
    public void testOnTreeWithMultipleNodes() {
        BinaryTree tree = new BinaryTree();
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');
        tree.insert('E');

        assertEquals(5, tree.size());
        assertEquals(3, tree.height());

        assertEquals("ABDEC", tree.preorder());  
        assertEquals("DBEAC", tree.inorder());   
        assertEquals("DEBCA", tree.postorder()); 
        assertEquals("ABCDE", tree.levelorder()); 
    }

    @Test
    public void testOnTreeWithDifferentStructure() {
        BinaryTree tree = new BinaryTree();
        tree.insert('M');
        tree.insert('N');
        tree.insert('O');
        tree.insert('P');
        tree.insert('Q');

        assertEquals(5, tree.size());
        assertEquals(3, tree.height());

        assertEquals("MNPQO", tree.preorder());
        assertEquals("PNQMO", tree.inorder());
        assertEquals("PQNOM", tree.postorder());
        assertEquals("MNOPQ", tree.levelorder());
    }


    @Test
    public void testInsertIntoEmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.isEmpty());
        
        tree.insert('A');

        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());
        assertEquals("A", tree.levelorder()); 
    }

    @Test
    public void testInsertSingleChild() {
        BinaryTree tree = new BinaryTree();
        tree.insert('A');
        tree.insert('B');

        assertEquals(2, tree.size());
        assertTrue(tree.search('B'));
        assertEquals("AB", tree.levelorder()); 
    }

    @Test
    public void testInsertTwoChildren() {
        BinaryTree tree = new BinaryTree();
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');

        assertEquals(3, tree.size());
        assertTrue(tree.search('C'));
        assertEquals("ABC", tree.levelorder()); 
    }

    @Test
    public void testInsertFillsLeftBeforeRight() {
        BinaryTree tree = new BinaryTree();
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');
        tree.insert('E');

        assertEquals(5, tree.size());
        assertEquals("ABCDE", tree.levelorder()); 
    }

    @Test
    public void testTreeHeightAfterInsertions() {
        BinaryTree tree = new BinaryTree();
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');

        assertEquals(3, tree.height()); 
    }

    @Test
    public void testInsertMultipleNodes() {
        BinaryTree tree = new BinaryTree();
        tree.insert('M');
        tree.insert('N');
        tree.insert('O');
        tree.insert('P');
        tree.insert('Q');
        tree.insert('R');

        assertEquals(6, tree.size());
        assertEquals("MNOPQR", tree.levelorder()); 
    }

    @Test
    public void testInsertAndSearch() {
        BinaryTree tree = new BinaryTree();
        tree.insert('X');
        tree.insert('Y');
        tree.insert('Z');

        assertTrue(tree.search('X'));
        assertTrue(tree.search('Y'));
        assertTrue(tree.search('Z'));
        assertFalse(tree.search('A')); 
    }

    



}
