package csc223.kb;

public interface Heap {

    // Insert an item to the heap
    void insert(char value);

    // Delete the root element from the heap
    void delete();

    // Get the root element of the heap
    char peek();

    // Get the size of the heap
    int size();

    // Check if the heap is empty
    boolean isEmpty();

    // Clear the heap
    void clear();

    // Return a string representation of all elements in the heap
    String toString();

}
