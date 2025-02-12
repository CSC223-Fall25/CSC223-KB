package csc223.kb;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SortedLinkedListTest {

    @Test
    void testInsert() {
        SortedLinkedList sortedList = new SortedLinkedList();
        
        assertTrue(sortedList.isEmpty());
        
        // Insert elements and verify sorting order
        sortedList.insert('B');
        assertEquals("B", sortedList.toString());

        sortedList.insert('A');
        assertEquals("AB", sortedList.toString());
        
        sortedList.insert('D');
        assertEquals("ABD", sortedList.toString());
        
        sortedList.insert('C');
        assertEquals("ABCD", sortedList.toString());
    }

    @Test
    void testRemove() {
        SortedLinkedList sortedList = new SortedLinkedList();
        sortedList.insert('A');
        sortedList.insert('B');
        sortedList.insert('C');
        
        // Remove head element
        sortedList.remove('A');
        assertEquals("BC", sortedList.toString());
        
        // Remove tail element
        sortedList.remove('C');
        assertEquals("B", sortedList.toString());
        
        // Remove last element
        sortedList.remove('B');
        assertEquals("", sortedList.toString());
    }

    @Test
    void testGetFirst() {
        SortedLinkedList sortedList = new SortedLinkedList();
        
        // Check first element when list is empty
        assertEquals('☠', sortedList.getFirst());
        
        sortedList.insert('X');
        assertEquals('X', sortedList.getFirst());

        sortedList.insert('Y');
        assertEquals('X', sortedList.getFirst());
    }

    @Test
    void testGetLast() {
        SortedLinkedList sortedList = new SortedLinkedList();
        
        // Check last element when list is empty
        assertEquals('☠', sortedList.getLast());
        
        sortedList.insert('X');
        assertEquals('X', sortedList.getLast());

        sortedList.insert('Y');
        assertEquals('Y', sortedList.getLast());
    }

    @Test
    void testGetByIndex() {
        SortedLinkedList sortedList = new SortedLinkedList();
        sortedList.insert('A');
        sortedList.insert('B');
        sortedList.insert('C');

        // Check elements by index
        assertEquals('A', sortedList.get(0));
        assertEquals('B', sortedList.get(1));
        assertEquals('C', sortedList.get(2));
        
        // Check out-of-bounds access
        assertEquals('☠', sortedList.get(3));
        assertEquals('☠', sortedList.get(-1));
    }

    @Test
    void testSize() {
        SortedLinkedList sortedList = new SortedLinkedList();
        assertEquals(0, sortedList.size());

        sortedList.insert('A');
        assertEquals(1, sortedList.size());

        sortedList.insert('B');
        assertEquals(2, sortedList.size());

        sortedList.remove('A');
        assertEquals(1, sortedList.size());

        sortedList.remove('B');
        assertEquals(0, sortedList.size());
    }

    @Test
    void testIsEmpty() {
        SortedLinkedList sortedList = new SortedLinkedList();
        assertTrue(sortedList.isEmpty());

        sortedList.insert('A');
        assertFalse(sortedList.isEmpty());

        sortedList.remove('A');
        assertTrue(sortedList.isEmpty());
    }

    @Test
    void testClear() {
        SortedLinkedList sortedList = new SortedLinkedList();
        sortedList.insert('A');
        sortedList.insert('B');
        sortedList.insert('C');
        
        sortedList.clear();
        assertEquals(0, sortedList.size());
        assertTrue(sortedList.isEmpty());
        assertEquals('☠', sortedList.getFirst());
        assertEquals('☠', sortedList.getLast());
    }

    @Test
    void testContains() {
        SortedLinkedList sortedList = new SortedLinkedList();
        assertFalse(sortedList.contains('A'));
        
        sortedList.insert('A');
        assertTrue(sortedList.contains('A'));
        assertFalse(sortedList.contains('B'));
    }

    @Test
    void testIndexOf() {
        SortedLinkedList sortedList = new SortedLinkedList();
        sortedList.insert('A');
        sortedList.insert('B');
        sortedList.insert('C');
        sortedList.insert('B');

        assertEquals(0, sortedList.indexOf('A'));
        assertEquals(1, sortedList.indexOf('B'));
        assertEquals(3, sortedList.indexOf('C'));
        assertEquals(-1, sortedList.indexOf('X'));
    }

    @Test
    void testLastIndexOf() {
        SortedLinkedList sortedList = new SortedLinkedList();
        sortedList.insert('A');
        sortedList.insert('B');
        sortedList.insert('C');
        sortedList.insert('B');

        assertEquals(0, sortedList.lastIndexOf('A'));
        assertEquals(2, sortedList.lastIndexOf('B'));
        assertEquals(3, sortedList.lastIndexOf('C'));
        assertEquals(-1, sortedList.lastIndexOf('X'));
    }

    @Test
    void testToString() {
        SortedLinkedList sortedList = new SortedLinkedList();
        assertEquals("", sortedList.toString());

        sortedList.insert('A');
        assertEquals("A", sortedList.toString());

        sortedList.insert('B');
        sortedList.insert('C');
        assertEquals("ABC", sortedList.toString());

        sortedList.remove('B');
        assertEquals("AC", sortedList.toString());
    }
}
