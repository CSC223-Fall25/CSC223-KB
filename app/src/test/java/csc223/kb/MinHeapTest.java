package csc223.kb;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MinHeapTest {
    
    @Test
    public void testInsertSingleElement() {
        MinHeap heap = new MinHeap();

        heap.insert(5);

        assertEquals(1, heap.size());
        assertEquals(5, heap.peek());
        assertTrue(heap.toString().equals("5"));
    }

    @Test
    public void testInsertMultipleElements() {
        MinHeap heap = new MinHeap();

        heap.insert(5);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        heap.insert(2);
        heap.insert(6);
        heap.insert(4);

        assertEquals(7, heap.size());
        assertEquals(1, heap.peek());
        assertTrue(heap.toString().equals("1 2 3 4 5 6 7"));        
    }

    @Test
    public void testInsertAscendingOrder() {
        MinHeap heap = new MinHeap();

        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);

        assertEquals(7, heap.size());
        assertEquals(1, heap.peek());
        assertTrue(heap.toString().equals("1 2 3 4 5 6 7"));
    }

    @Test
    public void testInsertDescendingOrder() {
        MinHeap heap = new MinHeap();

        heap.insert(7);
        heap.insert(6);
        heap.insert(5);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);

        assertEquals(7, heap.size());
        assertEquals(1, heap.peek());
        assertTrue(heap.toString().equals("1 2 3 4 5 6 7"));
    }

    @Test
    public void testDuplicateValue() {
        MinHeap heap = new MinHeap();

        heap.insert(5);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        heap.insert(2);
        heap.insert(6);
        heap.insert(4);
        heap.insert(1);

        assertEquals(7, heap.size());
        assertEquals(1, heap.peek());
        assertTrue(heap.toString().equals("1 2 3 4 5 6 7"));
    }

    @Test
    public void testDeleteNode() {
        MinHeap heap = new MinHeap();

        heap.insert(5);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        heap.insert(2);
        heap.insert(6);
        heap.insert(4);

        heap.delete();

        assertEquals(6, heap.size());
        assertEquals(2, heap.peek());
        assertTrue(heap.toString().equals("2 3 4 5 7 6"));
    }

    @Test
    public void testDeleteAllNodes() {
        MinHeap heap = new MinHeap();

        heap.insert(5);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        heap.insert(2);
        heap.insert(6);
        heap.insert(4);

        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();
        heap.delete();

        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
        assertTrue(heap.toString().equals(""));
    }

    @Test
    public void testDeleteFromEmptyHeap() {
        MinHeap heap = new MinHeap();

        heap.delete();

        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
        assertTrue(heap.toString().equals(""));
    }


}
