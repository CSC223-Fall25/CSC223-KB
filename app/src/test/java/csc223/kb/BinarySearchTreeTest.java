package csc223.kb;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void testInsertEmptyTree() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        assertTrue(bst.search(10));
    }

    @Test
    public void testInsertSmallerValue() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);

        assertTrue(bst.search(5));
    }

    @Test
    public void testInsertGreaterValue() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(15);

        assertTrue(bst.search(15));
    }

    @Test
    public void testInsertMultipleValues() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(13);
        bst.insert(20);

        assertTrue(bst.search(3));
        assertFalse(bst.search(21));
        assertTrue(bst.search(13));
        assertTrue(bst.search(20));
    }

    @Test
    public void testInsertDuplicateValue() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(10);

        assertTrue(bst.search(10));
    }

    @Test
    public void testInsertNegNumbers() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(-10);
        bst.insert(-5);
        bst.insert(-15);

        assertTrue(bst.search(-10));
        assertTrue(bst.search(-5));
        assertTrue(bst.search(-15));
    }


    @Test
    public void testDeleteLeafNode() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        
        bst.delete(5);

        assertFalse(bst.search(5));
        assertTrue(bst.search(10));
        assertTrue(bst.search(15));
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(3);
        
        bst.delete(5);

        assertFalse(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(10));
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12);
        bst.insert(17);
        
        bst.delete(15);

        assertFalse(bst.search(15));
        assertTrue(bst.search(10));
        assertTrue(bst.search(12));
        assertTrue(bst.search(17));
    }

    @Test
    public void testDeleteRootNode() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        
        bst.delete(10);

        assertFalse(bst.search(10));
        assertTrue(bst.search(5));
        assertTrue(bst.search(15));
    }

    @Test
    public void testDeleteNonExistentNode() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        
        bst.delete(20);

        assertTrue(bst.search(10));
        assertTrue(bst.search(5));
        assertTrue(bst.search(15));
    }

    @Test
    public void testDeleteFromEmptyTree() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.delete(10);
        assertFalse(bst.search(10));
    }


    @Test
    public void testSearchNonExistentValue() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        assertFalse(bst.search(5));
    }

    @Test
    public void testSearchInEmptyTree() {
        BinarySearchTree bst = new BinarySearchTree();

        assertFalse(bst.search(10));
    }

    @Test
    public void testSearchSmallestValue() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);

        assertTrue(bst.search(2));
    }

    @Test
    public void testSearchLargestValue() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(20);
        bst.insert(30);

        assertTrue(bst.search(30));
    }

    @Test
    public void testSearchAfterDeletion() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.delete(5);

        assertFalse(bst.search(5));
    }

    @Test
    public void testSearchNegativeNumbers() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(-10);
        bst.insert(-5);

        assertTrue(bst.search(-10));
        assertTrue(bst.search(-5));
        assertFalse(bst.search(-1));
    }

    @Test
    public void testUpdateExistingValue() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.update(10, 15);

        assertFalse(bst.search(10));
        assertTrue(bst.search(15));
    }

    @Test
    public void testUpdateNonExistentValue() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.update(5, 15);

        assertFalse(bst.search(15));
        assertTrue(bst.search(10));
    }

    @Test
    public void testUpdateToExistingValue() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(15);
        bst.update(10, 15);

        assertFalse(bst.search(10));
        assertTrue(bst.search(15));
    }

    @Test
    public void testUpdateSmallestValue() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(2);
        bst.update(2, 3);
        assertFalse(bst.search(2));
        assertTrue(bst.search(3));
    }

    @Test
    public void testUpdateLargestValue() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(15);
        bst.insert(20);
        bst.update(20, 25);

        assertFalse(bst.search(20));
        assertTrue(bst.search(25));
    }

    @Test
    public void testUpdateRootNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.update(10, 12);

        assertFalse(bst.search(10));
        assertTrue(bst.search(12));
        assertTrue(bst.search(5));
        assertTrue(bst.search(15));
    }

    @Test
    public void testUpdateNegativeNumbers() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(-10);
        bst.insert(-5);
        bst.update(-10, -20);

        assertFalse(bst.search(-10));
        assertTrue(bst.search(-20));
        assertTrue(bst.search(-5));
    }

    @Test
    public void testInOrderOnEmptyTree() {
        BinarySearchTree bst = new BinarySearchTree();
        assertEquals("", bst.inOrder());
    }

    @Test
    public void testInOrderWithOneElement() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        assertEquals("10", bst.inOrder());
    }

    @Test
    public void testInOrderWithMultipleElements() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(13);
        bst.insert(20);

        assertEquals("3 5 7 10 13 15 20", bst.inOrder());
    }

    @Test
    public void testInOrderAfterDeletion() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.delete(5);

        assertEquals("3 7 10 15", bst.inOrder());
    }

    @Test
    public void testInOrderWithNegativeNumbers() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(-10);
        bst.insert(-5);
        bst.insert(-20);
        bst.insert(0);
        bst.insert(15);

        assertEquals("-20 -10 -5 0 15", bst.inOrder());
    }

    @Test
    public void testSortedArrayToBSTWithEmptyArray() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.sortedArrayToBST(new int[]{});
        assertEquals("", bst.inOrder());
    }

    @Test
    public void testSortedArrayToBSTWithOneElement() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.sortedArrayToBST(new int[]{10});
        assertEquals("10", bst.inOrder());
    }

    @Test
    public void testSortedArrayToBSTWithTwoElements() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.sortedArrayToBST(new int[]{5, 10});
        assertEquals("5 10", bst.inOrder());
    }

    @Test
    public void testSortedArrayToBSTWithOddNumberOfElements() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5});
        assertEquals("1 2 3 4 5", bst.inOrder());
    }

    @Test
    public void testSortedArrayToBSTWithEvenNumberOfElements() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.sortedArrayToBST(new int[]{2, 4, 6, 8, 10, 12});
        assertEquals("2 4 6 8 10 12", bst.inOrder());
    }

    @Test
    public void testSortedArrayToBSTWithNegativeNumbers() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.sortedArrayToBST(new int[]{-10, -5, 0, 5, 10});
        assertEquals("-10 -5 0 5 10", bst.inOrder());
    }

    @Test
    public void testSortedArrayToBSTWithLargeNumbers() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.sortedArrayToBST(new int[]{100, 200, 300, 400, 500});
        assertEquals("100 200 300 400 500", bst.inOrder());
    }

    @Test
    public void testLowestCommonAncestorWithRootAsLCA() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        assertEquals(20, bst.lowestCommonAncestor(10, 30));
    }

    @Test
    public void testLowestCommonAncestorWithLeftSubtree() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        assertEquals(10, bst.lowestCommonAncestor(5, 15));
    }

    @Test
    public void testLowestCommonAncestorWithRightSubtree() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(30);
        bst.insert(25);
        bst.insert(35);
        assertEquals(30, bst.lowestCommonAncestor(25, 35));
    }

    @Test
    public void testLowestCommonAncestorWithNodesOnDifferentSubtrees() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(15);
        bst.insert(25);
        bst.insert(35);
        assertEquals(20, bst.lowestCommonAncestor(5, 35));
    }

    @Test
    public void testLowestCommonAncestorWhenOneNodeIsAncestorOfAnother() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(10);
        bst.insert(5);
        assertEquals(10, bst.lowestCommonAncestor(10, 5));
    }

    @Test
    public void testLowestCommonAncestorWhenNodesAreSame() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);
        assertEquals(20, bst.lowestCommonAncestor(20, 20));
    }

    @Test
    public void testLowestCommonAncestorWithNonExistentNode() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(10);
        bst.insert(30);

        assertEquals(-1, bst.lowestCommonAncestor(10, 40)); 
    }

}
