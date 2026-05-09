import java.util.Arrays;
import java.util.Random;

public class HeapSorter {

    // heap sort using priority queue
    public static void heapSort(Integer[] arr) {
        HeapPriorityQueue<Integer> pq = new HeapPriorityQueue<>();

        // Step 1: insert everything into heap
        for (Integer x : arr) {
            pq.insert(x);
        }

        // Step 2: remove min one by one (sorted order)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.removeMin();
        }
    }

    public static void main(String[] args) {

        Integer[] data = new Integer[10];
        Random rand = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(100);
        }

        System.out.println("Before Sorting: " + Arrays.toString(data));

        heapSort(data);

        System.out.println("After Sorting:  " + Arrays.toString(data));
    }
}
