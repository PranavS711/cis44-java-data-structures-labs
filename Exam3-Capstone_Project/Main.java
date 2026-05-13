public class Main {

    public static void main(String[] args) {

        PriorityQueueHeap scheduler = new PriorityQueueHeap();

        
        // Test 1: Empty heap behavior
        if (scheduler.isEmpty() && scheduler.poll() == null) {
            System.out.println("PASS: Empty heap handling");
        } else {
            System.out.println("FAIL: Empty heap handling");
        }

        // Test 2: Insert + ordering correctness
        scheduler.insert(new Task("A", 3));
        scheduler.insert(new Task("B", 1));
        scheduler.insert(new Task("C", 2));

        Task first = scheduler.poll();

        if (first.getPriority() == 1) {
            System.out.println("PASS: Priority ordering");
        } else {
            System.out.println("FAIL: Priority ordering");
        }

        // Test 3: Tie handling
        PriorityQueueHeap heap2 = new PriorityQueueHeap();
        heap2.insert(new Task("X", 2));
        heap2.insert(new Task("Y", 2));

        Task t1 = heap2.poll();
        Task t2 = heap2.poll();

        if (t1 != null && t2 != null) {
            System.out.println("PASS: Tie handling");
        } else {
            System.out.println("FAIL: Tie handling");
        }
    }
}
