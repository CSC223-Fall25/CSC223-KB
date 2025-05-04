package csc223.kb;
import java.util.ArrayList;
import java.util.List;

public class MyHashtable {
    class KVPair {
        String key;
        Integer value;

        KVPair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    List<List<KVPair>> buckets;
    int size;
    int capacity;

    public MyHashtable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    private int getIndex(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(String key, Integer value) {
        int index = getIndex(key);
        List<KVPair> bucket = buckets.get(index);

        for (KVPair pair : bucket) {
            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }

        bucket.add(new KVPair(key, value));
        size++;
    }

    public Integer get(String key) {
        int index = getIndex(key);
        List<KVPair> bucket = buckets.get(index);

        for (KVPair pair : bucket) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }

        return null;
    }

    public boolean containsKey(String key) {
        int index = getIndex(key);
        List<KVPair> bucket = buckets.get(index);
    
        for (KVPair pair : bucket) {
            if (pair.key.equals(key)) {
                return true;
            }
        }
    
        return false;
    }
    

    public void remove(String key) {
        int index = getIndex(key);
        List<KVPair> bucket = buckets.get(index);

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                bucket.remove(i);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }
}
