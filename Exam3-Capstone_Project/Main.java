public class Main {

    public static void main(String[] args) {

        PriorityQueueHeap scheduler = new PriorityQueueHeap();

        // Insert tasks
        scheduler.insert(new Task("Low priority cleanup", 5));
        scheduler.insert(new Task("Fix critical bug", 1));
        scheduler.insert(new Task("Write documentation", 4));
        scheduler.insert(new Task("Emergency server crash", 0));
        scheduler.insert(new Task("Code review", 3));

        System.out.println("Processing tasks in priority order:\n");

        // Process tasks in correct order
        while (!scheduler.isEmpty()) {
            Task task = scheduler.poll();
            System.out.println(task);
        }
    }
}
