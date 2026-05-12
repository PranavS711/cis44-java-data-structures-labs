import java.util.ArrayList;

//  Entry ADT
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

// Implementation: Unsorted List Map 
class UnsortedListMap<K, V> implements MapADT<K, V> {

    private ArrayList<Entry<K, V>> list = new ArrayList<>();

    // Helper method: linear search (O(n))
    private int findEntryIndex(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    // Size of map
    public int size() {
        return list.size();
    }

    // Check empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Get value by key (O(n))
    public V get(K key) {
        int i = findEntryIndex(key);
        return (i != -1) ? list.get(i).getValue() : null;
    }

    // Remove key (O(n))
    public V remove(K key) {
        int i = findEntryIndex(key);
        if (i != -1) {
            V oldValue = list.get(i).getValue();
            list.remove(i);
            return oldValue;
        }
        return null;
    }

    // Put method (O(n)) 
    public V put(K key, V value) {
        // 1. Search for existing key
        int i = findEntryIndex(key);

        // 2. If found, update and return old value
        if (i != -1) {
            return list.get(i).setValue(value);
        }

        // 3. If not found, add new entry
        list.add(new Entry<>(key, value));
        return null;
    }
}
