import java.util.ArrayList;

public class PriorityQueueHeap {

    private ArrayList<Task> heap;

    // Constructor
    public PriorityQueueHeap() {
        heap = new ArrayList<>();
    }

  
    public void insert(Task task) {
        heap.add(task);
        heapifyUp(heap.size() - 1);
    }

   
    public Task poll() {
        if (heap.isEmpty()) return null;

        Task root = heap.get(0);
        Task last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return root;
    }

    // Peek (no removal)
    public Task peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

   
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (heap.get(index).getPriority() < heap.get(parentIndex).getPriority()) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

 
    private void heapifyDown(int index) {
        int smallest = index;

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < heap.size() &&
                heap.get(left).getPriority() < heap.get(smallest).getPriority()) {
                smallest = left;
            }

            if (right < heap.size() &&
                heap.get(right).getPriority() < heap.get(smallest).getPriority()) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    // Swap helper method
    private void swap(int i, int j) {
        Task temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Optional helper (for testing)
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
}
