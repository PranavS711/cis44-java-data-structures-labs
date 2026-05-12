public class Task {
    private String name;
    private int priority;

    // Constructor
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    // Optional: helpful for debugging
    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}
