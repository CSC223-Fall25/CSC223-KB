package csc223.kb;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    @Test
    void testInsert() {
        DoublyLinkedList dll = new DoublyLinkedList();
        
        // Check if dll is initially empty
        assertTrue(dll.isEmpty());
        
        // Insert elements and verify
        dll.insert('A');
        assertEquals('A', dll.getFirst());
        assertEquals('A', dll.getLast());
        assertEquals(1, dll.size());

        dll.insert('B');
        assertEquals('A', dll.getFirst());
        assertEquals('B', dll.getLast());
        assertEquals(2, dll.size());

        dll.insert('C');
        assertEquals('A', dll.getFirst());
        assertEquals('C', dll.getLast());
        assertEquals(3, dll.size());
    }

    @Test
    void testRemove() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert('A');
        dll.insert('B');
        dll.insert('C');

        // Remove head element
        dll.remove('A');
        assertEquals('B', dll.getFirst());
        assertEquals('C', dll.getLast());
        assertEquals(2, dll.size());

        // Remove tail element
        dll.remove('C');
        assertEquals('B', dll.getFirst());
        assertEquals('B', dll.getLast());
        assertEquals(1, dll.size());

        // Remove last element
        dll.remove('B');
        assertEquals('☠', dll.getFirst());
        assertEquals('☠', dll.getLast());
        assertEquals(0, dll.size());
    }

    @Test
    void testGetFirst() {
        DoublyLinkedList dll = new DoublyLinkedList();
        
        // Check first element when dll is empty
        assertEquals('☠', dll.getFirst());
        
        dll.insert('X');
        assertEquals('X', dll.getFirst());

        dll.insert('Y');
        assertEquals('X', dll.getFirst());
    }

    @Test
    void testGetLast() {
        DoublyLinkedList dll = new DoublyLinkedList();
        
        // Check last element when dll is empty
        assertEquals('☠', dll.getLast());
        
        dll.insert('X');
        assertEquals('X', dll.getLast());

        dll.insert('Y');
        assertEquals('Y', dll.getLast());
    }

    @Test
    void testGetByIndex() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert('A');
        dll.insert('B');
        dll.insert('C');

        // Check elements by index
        assertEquals('A', dll.get(0));
        assertEquals('B', dll.get(1));
        assertEquals('C', dll.get(2));
        
        // Check out-of-bounds access
        assertEquals('☠', dll.get(3));
        assertEquals('☠', dll.get(-1));
    }

    @Test
    void testSize() {
        DoublyLinkedList dll = new DoublyLinkedList();
        assertEquals(0, dll.size());

        dll.insert('A');
        assertEquals(1, dll.size());

        dll.insert('B');
        assertEquals(2, dll.size());

        dll.remove('A');
        assertEquals(1, dll.size());

        dll.remove('B');
        assertEquals(0, dll.size());
    }

    @Test
    void testIsEmpty() {
        DoublyLinkedList dll = new DoublyLinkedList();
        assertTrue(dll.isEmpty());

        dll.insert('A');
        assertFalse(dll.isEmpty());

        dll.remove('A');
        assertTrue(dll.isEmpty());
    }

    @Test
    void testClear() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert('A');
        dll.insert('B');
        dll.insert('C');
        
        dll.clear();
        assertEquals(0, dll.size());
        assertTrue(dll.isEmpty());
        assertEquals('☠', dll.getFirst());
        assertEquals('☠', dll.getLast());
    }

    @Test
    void testContains() {
        DoublyLinkedList dll = new DoublyLinkedList();
        assertFalse(dll.contains('A'));
        
        dll.insert('A');
        assertTrue(dll.contains('A'));
        assertFalse(dll.contains('B'));
    }

    @Test
    void testIndexOf() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert('A');
        dll.insert('B');
        dll.insert('C');
        dll.insert('B');

        assertEquals(0, dll.indexOf('A'));
        assertEquals(1, dll.indexOf('B'));
        assertEquals(2, dll.indexOf('C'));
        assertEquals(-1, dll.indexOf('X'));
    }


    @Test
    void testLastIndexOf() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');
        list.insert('B');

        assertEquals(0, list.lastIndexOf('A'));
        assertEquals(3, list.lastIndexOf('B'));
        assertEquals(2, list.lastIndexOf('C'));
        assertEquals(-1, list.lastIndexOf('X'));
    }

    @Test
    void testReverse() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.reverse();
        assertEquals("", dll.toString());

        dll.insert('A');
        dll.reverse();
        assertEquals("A", dll.toString());

        dll.insert('B');
        dll.insert('C');
        dll.insert('D');
        
        dll.reverse();
        assertEquals("DCBA", dll.toString());

        dll.reverse();
        assertEquals("ABCD", dll.toString());
    }

    @Test
    void testToString() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertEquals("", list.toString());

        list.insert('A');
        assertEquals("A", list.toString());

        list.insert('B');
        list.insert('C');
        assertEquals("ABC", list.toString());

        list.remove('B');
        assertEquals("AC", list.toString());
    }

}
