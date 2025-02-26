package csc223.kb;

public class SinglyLinkedList {
    protected Node head;
    protected int size;

    public SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }


    public void insert(char item){
        Node newnode = new Node(item);
        if (head == null){
            head = newnode;
        }
        else{
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newnode;
        }
        size++;
    }

    public void remove(char item) {
        if (head == null) {
            return;
        }
    
        if (head.data == item) {
            head = head.next;
            size--;
            return;
        }
    
        Node curr = head;
    
        while (curr.next != null) {
            if (curr.next.data == item) {
                curr.next = curr.next.next;
                size--;
                return; 
            }
            
            curr = curr.next;
        }
    }
    
    
    


    public char getFirst() {
        if (head == null) {
            return '☠';
        } else {
            return head.data;
        }
    }


    public char getLast() {
        if (head == null) {
            return '☠';
        }
        
        Node curr = head;
        while (curr.next != null){
            curr = curr.next;
        }
        return curr.data;
    }


    public char get(int index){
        if (index < 0 || index >= size){
            return '☠';
        }
        Node curr = head;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr.data;
    }
    

    public int size(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        head = null;
        size = 0;
    }


    public boolean contains(char item) {
        if (head == null) {
            return false;
        }
    
        Node curr = head;
        while (curr != null) {
            if (curr.data == item) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }


    public int indexOf(char item) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data == item){
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }


    public int lastIndexOf(char item) {
        Node curr = head;

        int index = 0;
        int lastIndex = -1;

        while (curr != null) {
            if (curr.data == item) {
                lastIndex = index;
            }
            curr = curr.next;
            index++;
        }
        return lastIndex;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
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
