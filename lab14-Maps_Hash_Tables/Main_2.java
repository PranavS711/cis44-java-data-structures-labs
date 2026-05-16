import java.util.ArrayList;
import java.util.LinkedList;

// Entry ADT
class Entry<K, V> {
    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }
}

// Common Map Interface
interface MapADT<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
}

// Separate Chaining Hash Map
class SeparateChainingMap<K, V> implements MapADT<K, V> {
    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size = 0;
    private final int N = 11; // prime number for table size

    public SeparateChainingMap() {
        table = new ArrayList<>(N);

        // Create empty buckets
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<Entry<K, V>>());
        }
    }

    // Hash function
    private int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Get value by key
    public V get(K key) {
        // 1. Calculate the bucket index
        int h = hash(key);

        // 2. Get the bucket at that index
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // 3. Search the bucket for the key
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        // 4. Key was not found
        return null;
    }

    // Put key-value pair into map
    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // Check if key already exists
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.setValue(value);
            }
        }

        // Key is new, so add it
        bucket.addFirst(new Entry<>(key, value));
        size++;
        return null;
    }

    // Remove key from map
    public V remove(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        Entry<K, V> toRemove = null;

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            V oldValue = toRemove.getValue();
            bucket.remove(toRemove);
            size--;
            return oldValue;
        }

        return null;
    }
}

// Driver class to test the hash map
public class Main {
    public static void main(String[] args) {
        SeparateChainingMap<Integer, String> map = new SeparateChainingMap<>();

        System.out.println("put(5, A): " + map.put(5, "A"));
        System.out.println("put(7, B): " + map.put(7, "B"));
        System.out.println("put(2, C): " + map.put(2, "C"));
        System.out.println("put(2, E): " + map.put(2, "E"));
        System.out.println("get(7): " + map.get(7));
        System.out.println("remove(5): " + map.remove(5));

        System.out.println("size(): " + map.size());
        System.out.println("isEmpty(): " + map.isEmpty());
    }
}
