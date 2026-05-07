import java.util.LinkedList;

public class SortedListPQ<K extends Comparable<K>, V>
        implements PriorityQueue<K, V> {

    // linked list to store entries
    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    // checks if empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // inserts in sorted order
    // O(n)
    public void insert(K key, V value) {

        MyEntry<K, V> newEntry = new MyEntry<>(key, value);

        // loop through list
        for (int i = 0; i < list.size(); i++) {

            // insert before bigger key
            if (newEntry.compareTo(list.get(i)) < 0) {
                list.add(i, newEntry);
                return;
            }
        }

        // add to end if biggest
        list.addLast(newEntry);
    }

    // gets smallest entry
    // O(1)
    public MyEntry<K, V> min() {

        if (isEmpty()) {
            return null;
        }

        return list.getFirst();
    }

    // removes smallest entry
    // O(1)
    public MyEntry<K, V> removeMin() {

        if (isEmpty()) {
            return null;
        }

        return list.removeFirst();
    }
}
