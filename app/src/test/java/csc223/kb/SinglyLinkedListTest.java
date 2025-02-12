package csc223.kb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

    @Test
    void testInsert() {
        SinglyLinkedList sll = new SinglyLinkedList();
        
        assertEquals(0, sll.size);
        assertEquals('☠', sll.getFirst());
        assertEquals('☠', sll.getLast());

        sll.insert('A');
        assertEquals(1, sll.size);
        assertEquals('A', sll.getFirst());
        assertEquals('A', sll.getLast());

        sll.insert('B');
        assertEquals(2, sll.size);
        assertEquals('A', sll.getFirst());
        assertEquals('B', sll.getLast());

        sll.insert('C');
        assertEquals(3, sll.size);
        assertEquals('A', sll.getFirst());
        assertEquals('C', sll.getLast());
    }

    @Test
    void testRemove() {
        SinglyLinkedList sll = new SinglyLinkedList();

        // Removing from empty list
        sll.remove('X'); 
        assertEquals(0, sll.size);

        sll.insert('A');
        sll.insert('B');
        sll.insert('C');
        sll.insert('B');
        sll.insert('D');

        // Removing first occurrence of 'B'
        sll.remove('B'); 
        assertEquals(4, sll.size);
        assertEquals('A', sll.getFirst());
        assertEquals('D', sll.getLast());

        // Removing head
        sll.remove('A'); 
        assertEquals(3, sll.size);
        assertEquals('C', sll.getFirst());

         // Removing tail
        sll.remove('D');
        assertEquals(2, sll.size);
        assertEquals('B', sll.getLast());

        sll.remove('C');
        assertEquals(1, sll.size);
        assertEquals('B', sll.getFirst());
        assertEquals('B', sll.getLast());

        // Removing last element
        sll.remove('B'); 
        assertEquals(0, sll.size);
        assertEquals('☠', sll.getFirst());
        assertEquals('☠', sll.getLast());

        // Removing non-existent element
        sll.remove('X'); 
        assertEquals(0, sll.size);
    }

    @Test
    void testGetFirst() {
        SinglyLinkedList sll = new SinglyLinkedList();
    
        // Empty list
        assertEquals('☠', sll.getFirst());
    
        sll.insert('A');
        assertEquals('A', sll.getFirst());
    
        sll.insert('B');
        // First element should remain same
        assertEquals('A', sll.getFirst());
    
        sll.remove('A');
        // First element should update
        assertEquals('B', sll.getFirst());
    }
    
    @Test
    void testGetLast() {
        SinglyLinkedList sll = new SinglyLinkedList();
    
        // Empty list
        assertEquals('☠', sll.getLast());
    
        sll.insert('A');
        assertEquals('A', sll.getLast());
    
        sll.insert('B');
        assertEquals('B', sll.getLast());
    
        sll.insert('C');
        assertEquals('C', sll.getLast());
    
        sll.remove('C');
        assertEquals('B', sll.getLast());
    
        sll.remove('B');
        assertEquals('A', sll.getLast());
    
        sll.remove('A');
        // List is empty
        assertEquals('☠', sll.getLast());
    }
    
    @Test
    void testGetByIndex() {
        SinglyLinkedList sll = new SinglyLinkedList();
    
        // Empty list
        assertEquals('☠', sll.get(0));
        // Invalid negative index
        assertEquals('☠', sll.get(-1));
        // Index out of bounds
        assertEquals('☠', sll.get(1));
    
        sll.insert('X');
        sll.insert('Y');
        sll.insert('Z');
    
        assertEquals('X', sll.get(0));
        assertEquals('Y', sll.get(1));
        assertEquals('Z', sll.get(2));
    
        // Out of bounds index
        assertEquals('☠', sll.get(3));
        // Negative index
        assertEquals('☠', sll.get(-2));
    }
    
    @Test
    void testSize() {
        SinglyLinkedList sll = new SinglyLinkedList();
        
        assertEquals(0, sll.size());
    
        sll.insert('A');
        assertEquals(1, sll.size());
    
        sll.insert('B');
        assertEquals(2, sll.size());
    
        sll.remove('A');
        assertEquals(1, sll.size());
    
        sll.remove('B');
        assertEquals(0, sll.size());
    }
    
    @Test
    void testIsEmpty() {
        SinglyLinkedList sll = new SinglyLinkedList();
    
        assertTrue(sll.isEmpty());
    
        sll.insert('A');
        assertFalse(sll.isEmpty());
    
        sll.remove('A');
        assertTrue(sll.isEmpty());
    }
    
    @Test
    void testClear() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insert('A');
        sll.insert('B');
        sll.insert('C');
    
        sll.clear();
        assertEquals(0, sll.size());
        assertTrue(sll.isEmpty());
        assertEquals('☠', sll.getFirst());
        assertEquals('☠', sll.getLast());
    }
    
    @Test
    void testContains() {
        SinglyLinkedList sll = new SinglyLinkedList();
    
        assertFalse(sll.contains('A'));
    
        sll.insert('A');
        sll.insert('B');
        sll.insert('C');
    
        assertTrue(sll.contains('A'));
        assertTrue(sll.contains('B'));
        assertTrue(sll.contains('C'));
        assertFalse(sll.contains('D'));
    
        sll.remove('B');
        assertFalse(sll.contains('B'));
    }
    
    @Test
    void testIndexOf() {
        SinglyLinkedList sll = new SinglyLinkedList();
    
        assertEquals(-1, sll.indexOf('A'));
    
        sll.insert('A');
        sll.insert('B');
        sll.insert('C');
        sll.insert('B');
    
        assertEquals(0, sll.indexOf('A'));
        assertEquals(1, sll.indexOf('B'));
        assertEquals(2, sll.indexOf('C'));
        assertEquals(-1, sll.indexOf('X'));
    }
    
    @Test
    void testLastIndexOf() {
        SinglyLinkedList sll = new SinglyLinkedList();
    
        assertEquals(-1, sll.lastIndexOf('A'));
    
        sll.insert('A');
        sll.insert('B');
        sll.insert('C');
        sll.insert('B');
        sll.insert('D');
    
        assertEquals(0, sll.lastIndexOf('A'));
        assertEquals(3, sll.lastIndexOf('B'));
        assertEquals(2, sll.lastIndexOf('C'));
        assertEquals(4, sll.lastIndexOf('D'));
        assertEquals(-1, sll.lastIndexOf('X'));
    }
    
    @Test
    void testReverse() {
        SinglyLinkedList sll = new SinglyLinkedList();
    
        // Reversing an empty list
        sll.reverse();
        assertEquals("", sll.toString());
    
        sll.insert('A');
        sll.reverse();
        assertEquals("A", sll.toString());
    
        sll.insert('B');
        sll.insert('C');
        sll.insert('D');
    
        sll.reverse();
        assertEquals("DCBA", sll.toString());
    
        sll.reverse();
        assertEquals("ABCD", sll.toString());
    }
    
    @Test
    void testToString() {
        SinglyLinkedList sll = new SinglyLinkedList();
    
        assertEquals("", sll.toString());
    
        sll.insert('A');
        assertEquals("A", sll.toString());
    
        sll.insert('B');
        sll.insert('C');
        assertEquals("ABC", sll.toString());
    
        sll.remove('B');
        assertEquals("AC", sll.toString());
    }
}    