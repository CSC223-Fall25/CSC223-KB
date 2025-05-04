package csc223.kb;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MyHashtableTest {

    @Test
    public void testPutAndGet() {
        MyHashtable table = new MyHashtable(10);

        // Basic ones
        table.put("apple", 10);
        table.put("banana", 20);
        table.put("orange", 30);

        assertEquals((Integer)10, table.get("apple"));
        assertEquals((Integer)20, table.get("banana"));
        assertEquals((Integer)30, table.get("orange"));

        // Overwriting the value
        table.put("apple", 99);
        assertEquals((Integer)99, table.get("apple"));

        // testing Collisions 
        table = new MyHashtable(1);
        table.put("key1", 1);
        table.put("key2", 2);
        table.put("key3", 3);

        assertEquals((Integer)1, table.get("key1"));
        assertEquals((Integer)2, table.get("key2"));
        assertEquals((Integer)3, table.get("key3"));

        assertNull(table.get("nonexistent"));

        table.put("key2", 1000);
        assertEquals((Integer)1000, table.get("key2"));
    
    }

    @Test
    public void testUpdate() {
        MyHashtable table = new MyHashtable(10);
        table.put("banana", 20);
        table.put("banana", 25);

        assertEquals((Integer)25, table.get("banana"));
    }

    @Test
    public void testUpdateValueXTimes() {
    MyHashtable table = new MyHashtable(10);
    
    table.put("banana", 20);
    table.put("banana", 25);
    table.put("banana", 30);
    
    assertEquals((Integer)30, table.get("banana"));
}

@Test
public void testPutUpdateAfterOther() {
    MyHashtable table = new MyHashtable(10);

    table.put("apple", 10);
    table.put("orange", 30);
    
    table.put("banana", 20);
    table.put("banana", 35);  
    
    assertEquals((Integer)35, table.get("banana"));
    assertEquals((Integer)10, table.get("apple"));
    assertEquals((Integer)30, table.get("orange"));
}

@Test
public void testUpdateNonExist() {
    MyHashtable table = new MyHashtable(10);

    table.put("nonexistent", 100);
    assertEquals((Integer)100, table.get("nonexistent"));
}


@Test
public void testContainsKey() {
    MyHashtable table = new MyHashtable(10);
    
    table.put("apple", 10);
    table.put("banana", 20);
    table.put("orange", 30);

    assertTrue(table.containsKey("apple"));
    assertTrue(table.containsKey("banana"));
    assertTrue(table.containsKey("orange"));

    // Non-exist key 
    assertFalse(table.containsKey("grape"));
    assertFalse(table.containsKey("watermelon"));

    // after removal 
    table.remove("banana");
    assertFalse(table.containsKey("banana"));
    
    // Contains after overwriting a value
    table.put("apple", 100); 
    assertTrue(table.containsKey("apple"));
}


@Test
public void testRemove() {
    MyHashtable table = new MyHashtable(10);

    table.put("apple", 10);
    table.put("banana", 20);
    table.put("orange", 30);

    table.remove("apple");

    assertNull(table.get("apple"));
    assertFalse(table.containsKey("apple"));

    assertEquals((Integer)20, table.get("banana"));
    assertTrue(table.containsKey("banana"));
    assertEquals((Integer)30, table.get("orange"));
    assertTrue(table.containsKey("orange"));

    table.remove("grape");  
    assertFalse(table.containsKey("grape"));

    table.remove("banana");
    table.remove("orange");
    assertEquals(0, table.size());
}


    @Test
    public void testSize() {
        MyHashtable table = new MyHashtable(10);
        table.put("apple", 10);
        table.put("banana", 20);
        table.put("orange", 30);
        assertEquals(3, table.size());

        table.remove("banana");
        assertEquals(2, table.size());
    }

    @Test
    public void testNullValue() {
        MyHashtable table = new MyHashtable(10);
        table.put("kiwi", null);

        assertNull(table.get("kiwi"));
        assertTrue(table.containsKey("kiwi"));
    }

    @Test
    public void testCollisionHandling() {
        MyHashtable table = new MyHashtable(2); 
        table.put("Aa", 1);
        table.put("BB", 2);

        assertEquals((Integer)1, table.get("Aa"));
        assertEquals((Integer)2, table.get("BB"));
    }

    @Test
    public void testSizeE() {
    MyHashtable table = new MyHashtable(10);

    assertEquals(0, table.size());

    table.put("apple", 10);
    assertEquals(1, table.size());

    table.put("banana", 20);
    table.put("orange", 30);
    assertEquals(3, table.size());

    table.put("apple", 99);
    assertEquals(3, table.size());

    table.remove("banana");
    assertEquals(2, table.size());

    table.remove("banana");
    assertEquals(2, table.size());

    table.put("grape", 40);
    assertEquals(3, table.size());
    table.remove("grape");
    assertEquals(2, table.size());
}



}
