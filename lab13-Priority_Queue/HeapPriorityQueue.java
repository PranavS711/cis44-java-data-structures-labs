import java.util.ArrayList;

class HeapPriorityQueue<K extends Comparable<K>> {
    private ArrayList<K> heap = new ArrayList<>();

    // helper methods to navigate heap
    protected int parent(int j) { return (j - 1) / 2; }
    protected int left(int j) { return 2 * j + 1; }
    protected int right(int j) { return 2 * j + 2; }

    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }

    // swap two elements in heap
    private void swap(int i, int j) {
        K temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // insert element at end then fix heap upward
    public void insert(K key) {
        heap.add(key);
        upheap(heap.size() - 1);
    }

    // remove smallest (root)
    public K removeMin() {
        if (isEmpty()) return null;

        K answer = heap.get(0);

        K last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0);
        }

        return answer;
    }

    public K min() {
        return isEmpty() ? null : heap.get(0);
    }

    // move node up until heap property is fixed
    private void upheap(int j) {
        while (j > 0) {
            int p = parent(j);

            if (heap.get(p).compareTo(heap.get(j)) <= 0) {
                break;
            }

            swap(j, p);
            j = p;
        }
    }

    // move node down until heap property is fixed
    private void downheap(int j) {
        while (left(j) < heap.size()) {

            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            int rightIndex = right(j);

            // check if right child exists and is smaller
            if (rightIndex < heap.size() &&
                heap.get(rightIndex).compareTo(heap.get(leftIndex)) < 0) {
                smallChildIndex = rightIndex;
            }

            // if already smaller than both children, stop
            if (heap.get(j).compareTo(heap.get(smallChildIndex)) <= 0) {
                break;
            }

            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }
}
