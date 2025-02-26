package csc223.kb;

public class SortedLinkedList extends DoublyLinkedList {

    public void insert(char item) {
        Node newnode = new Node(item);

        if (head == null) { 
            head = newnode;
            tail = newnode; 

        } else if (head.data >= item) { 
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        } else { 
            Node curr = head;

            while (curr.next != null && curr.next.data < item) {
                curr = curr.next;
            }

            newnode.next = curr.next;
            newnode.prev = curr;
            curr.next = newnode;

            if (newnode.next != null) {
                newnode.next.prev = newnode;
            } else {
                tail = newnode;
            }
        }
        size++;
    }

    public void remove(char item) {
        super.remove(item);
    }

    public char getFirst() {
        return super.getFirst();
    }

    public char getLast() {
        return super.getLast();
    }

    public char get(int index) {
        return super.get(index);
    }

    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public void clear() {
        super.clear();
    }

    public boolean contains(char item) {
        return super.contains(item);
    }

    public int indexOf(char item) {
        return super.indexOf(item);
    }

    public int lastIndexOf(char item) {
        return super.lastIndexOf(item);
    }

    public void reverse() {
        // Dr Sultan, I prevented reversal since list should always be sorted
    }

    public String toString() {
        return super.toString();
    }
}
