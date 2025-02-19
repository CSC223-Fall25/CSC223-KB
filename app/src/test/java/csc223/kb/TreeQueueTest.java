package csc223.kb;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TreeQueueTest {

    @Test
    public void testQueueInitialization() {
        TreeQueue queue = new TreeQueue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueSingleElement() {
        TreeQueue queue = new TreeQueue();
        TreeNode node = new TreeNode('A');
        queue.enqueue(node);

        assertFalse(queue.isEmpty());
    }

    @Test
    public void testDequeueSingleElement() {
        TreeQueue queue = new TreeQueue();
        TreeNode node = new TreeNode('A');
        queue.enqueue(node);

        assertEquals(node, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueMultipleElements() {
        TreeQueue queue = new TreeQueue();
        TreeNode nodeA = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        queue.enqueue(nodeA);
        queue.enqueue(nodeB);

        assertFalse(queue.isEmpty());
    }

    @Test
    public void testDequeueMultipleElementsInOrder() {
        TreeQueue queue = new TreeQueue();
        TreeNode nodeA = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        queue.enqueue(nodeA);
        queue.enqueue(nodeB);

        assertEquals(nodeA, queue.dequeue());
        assertEquals(nodeB, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testDequeueFromEmptyQueue() {
        TreeQueue queue = new TreeQueue();
        assertNull(queue.dequeue());
    }

    @Test
    public void testQueueDoesNotOverflow() {
        TreeQueue queue = new TreeQueue();
        for (int i = 0; i < 100; i++) {
            queue.enqueue(new TreeNode((char) ('A' + i)));
        }
        
        queue.enqueue(new TreeNode('Z')); 
        assertEquals('A', queue.dequeue().data);
    }

    @Test
    public void testQueueWrapAround() {
        TreeQueue queue = new TreeQueue();
        TreeNode nodeA = new TreeNode('A');
        queue.enqueue(nodeA);
        queue.dequeue(); 
        queue.enqueue(new TreeNode('B'));

        assertFalse(queue.isEmpty());
    }
}
