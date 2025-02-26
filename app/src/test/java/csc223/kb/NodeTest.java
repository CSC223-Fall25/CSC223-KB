package csc223.kb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    public void TestNodeData(){
        Node node = new Node('A');
        assertEquals('A', node.data);
        assertNull(node.next);
        assertNull(node.prev);
    }

    @Test
    public void TestNodeNext(){
        Node node1 = new Node('A');
        Node node2 = new Node('B');
        node1.next = node2;
        assertEquals(node2, node1.next);
    }

    @Test
    public void TestNodePrev(){
        Node node1 = new Node('A');
        Node node2 = new Node ('B');
        node2.prev = node1;
        assertEquals(node1, node2.prev);
    }

    @Test
    public void TestDifferentChars(){
        Node node1 = new Node('$');
        Node node2 = new Node('9');
        Node node3 = new Node('z');
        assertEquals('$', node1.data);
        assertEquals('9', node2.data);
        assertEquals('z', node3.data);
    }

    @Test
    public void testUpdateRefs() {
        Node node1 = new Node('A');
        Node node2 = new Node('B');
        Node node3 = new Node('C');

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;

        assertEquals(node2, node1.next);
        assertEquals(node1, node2.prev);
        assertEquals(node3, node2.next);
        assertEquals(node2, node3.prev);
    }

    
}
