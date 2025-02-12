package csc223.kb;

public class DoublyLinkedList extends SinglyLinkedList implements LinkedList {
    protected Node tail; 

    public DoublyLinkedList() {
        super(); 
        this.tail = null;
    }

    public void insert(char item) {
        Node newnode = new Node(item);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail; 
            tail = newnode; 
        }
        size++;
    }

    public void remove(char item) {
        if (head == null) {
            return;
        }

        if (head.data == item) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; 
            }
            size--;
            return;
        }

        Node curr = head;
        while (curr != null && curr.data != item) {
            curr = curr.next;
        }

        if (curr != null) {
            if (curr.next != null) {
                curr.next.prev = curr.prev;
            } else {
                tail = curr.prev; 
            }

            if (curr.prev != null) {
                curr.prev.next = curr.next;
            }
            size--;
        }
    }

    public char getFirst() {
        return super.getFirst(); 
    }

    public char getLast() {
        if (tail == null) {
            return '☠';
        }
        return tail.data;
    }

    public char get(int index) {
        if (index < 0 || index >= size) {
            return '☠';
        }

        Node curr;
        // Search from the head
        if (index < size / 2) { 
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        // Search from the tail
        } else { 
            curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr.data;
    }

    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public void clear() {
        super.clear();
        tail = null; 
    }

    public boolean contains(char item) {
        return super.contains(item);
    }

    public int indexOf(char item) {
        return super.indexOf(item);
    }

    public int lastIndexOf(char item) {
        Node curr = tail;
        int index = size - 1;

        while (curr != null) {
            if (curr.data == item) {
                return index;
            }
            curr = curr.prev;
            index--;
        }
        return -1;
    }

    public void reverse() {
        Node curr = head;
        Node temp = null;
    
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev; 
        }
    
        if (temp != null) {
            head = temp.prev;  
        }
    }
    

    public String toString() {
        String result = "";
        Node curr = head;
        while (curr != null) {
            result = result + curr.data;
            curr = curr.next;
        }
        return result;
    }
}
