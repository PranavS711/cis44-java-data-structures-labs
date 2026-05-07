import java.util.LinkedList;

public class UnsortedListPQ<K extends Comparable<K>, V>
        implements PriorityQueue<K, V> {

    // linked list to store entries
    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    // checks if list is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // inserts at end of list
    // O(1)
    public void insert(K key, V value) {
        list.addLast(new MyEntry<>(key, value));
    }

    // finds smallest entry
    // O(n)
    public MyEntry<K, V> min() {

        if (isEmpty()) {
            return null;
        }

        MyEntry<K, V> minEntry = list.getFirst();

        // loop through list
        for (MyEntry<K, V> entry : list) {

            // update min if smaller key found
            if (entry.compareTo(minEntry) < 0) {
                minEntry = entry;
            }
        }

        return minEntry;
    }

    // removes smallest entry
    // O(n)
    public MyEntry<K, V> removeMin() {

        if (isEmpty()) {
            return null;
        }

        // find smallest entry
        MyEntry<K, V> minEntry = min();

        // remove it from list
        list.remove(minEntry);

        return minEntry;
    }
}
