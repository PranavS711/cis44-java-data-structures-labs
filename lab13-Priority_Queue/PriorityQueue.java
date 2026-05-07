public interface PriorityQueue<K extends Comparable<K>, V> {

    // inserts a new entry
    void insert(K key, V value);

    // removes smallest key
    MyEntry<K, V> removeMin();

    // gets smallest key
    MyEntry<K, V> min();

    // checks if queue is empty
    boolean isEmpty();
}
