public class MyEntry<K extends Comparable<K>, V> implements Comparable<MyEntry<K, V>> {

    // stores the key
    private K key;

    // stores the value
    private V value;

    // constructor
    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // returns the key
    public K getKey() {
        return key;
    }

    // returns the value
    public V getValue() {
        return value;
    }

    // compares keys
    @Override
    public int compareTo(MyEntry<K, V> other) {
        return this.key.compareTo(other.key);
    }

    // prints entry nicely
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
