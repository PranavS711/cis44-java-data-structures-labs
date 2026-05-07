public class ListPQDriver {

    public static void main(String[] args) {

        System.out.println("--- UnsortedListPQ ---");

        PriorityQueue<Integer, String> pq1 =
                new UnsortedListPQ<>();

        pq1.insert(5, "Task E");
        pq1.insert(1, "Task A");
        pq1.insert(10, "Task G");
        pq1.insert(3, "Task C");

        // remove everything in order
        while (!pq1.isEmpty()) {
            System.out.println("Removed: " + pq1.removeMin());
        }

        System.out.println();

        System.out.println("--- SortedListPQ ---");

        PriorityQueue<Integer, String> pq2 =
                new SortedListPQ<>();

        pq2.insert(5, "Task E");
        pq2.insert(1, "Task A");
        pq2.insert(10, "Task G");
        pq2.insert(3, "Task C");

        // remove everything in order
        while (!pq2.isEmpty()) {
            System.out.println("Removed: " + pq2.removeMin());
        }
    }
}
