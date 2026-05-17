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
    private final int N = 11; // Small prime number for table size

    public SeparateChainingMap() {
        table = new ArrayList<>(N);

        // Create empty linked lists for each bucket
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<Entry<K, V>>());
        }
    }

    // Hash function
    private int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    // This is just for testing, so we can see what bucket a key goes into
    public int getBucketIndex(K key) {
        return hash(key);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Get value by key
    public V get(K key) {
        // Find the bucket index
        int h = hash(key);

        // Get the linked list at that bucket
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // Search through the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        // Key was not found
        return null;
    }

    // Put key-value pair into map
    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // Check if the key already exists
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.setValue(value);
            }
        }

        // Key is new, so add it to the bucket
        bucket.addFirst(new Entry<>(key, value));
        size++;
        return null;
    }

    // Remove key from map
    public V remove(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        Entry<K, V> toRemove = null;

        // Find the entry to remove
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }

        // Remove it if it was found
        if (toRemove != null) {
            V oldValue = toRemove.getValue();
            bucket.remove(toRemove);
            size--;
            return oldValue;
        }

        return null;
    }
}

// Main class to test the SeparateChainingMap
public class Main_2 {
    public static void main(String[] args) {
        SeparateChainingMap<String, String> map = new SeparateChainingMap<>();

        System.out.println("Testing SeparateChainingMap with String keys");
        System.out.println("------------------------------------------");

        // These String keys are expected to hash to the same bucket
        System.out.println("Bucket for Aa: " + map.getBucketIndex("Aa"));
        System.out.println("Bucket for BB: " + map.getBucketIndex("BB"));
        System.out.println("Bucket for AaAa: " + map.getBucketIndex("AaAa"));
        System.out.println();

        // Insert values
        System.out.println("put(Aa, Apple): " + map.put("Aa", "Apple"));
        System.out.println("put(BB, Banana): " + map.put("BB", "Banana"));
        System.out.println("put(AaAa, Cherry): " + map.put("AaAa", "Cherry"));
        System.out.println();

        // Get values to prove collision handling works
        System.out.println("get(Aa): " + map.get("Aa"));
        System.out.println("get(BB): " + map.get("BB"));
        System.out.println("get(AaAa): " + map.get("AaAa"));
        System.out.println();

        // Replace an existing value
        System.out.println("put(BB, Blueberry): " + map.put("BB", "Blueberry"));
        System.out.println("get(BB): " + map.get("BB"));
        System.out.println();

        // Remove a value
        System.out.println("remove(Aa): " + map.remove("Aa"));
        System.out.println("get(Aa): " + map.get("Aa"));
        System.out.println();

        // Final map info
        System.out.println("size(): " + map.size());
        System.out.println("isEmpty(): " + map.isEmpty());
    }
}
