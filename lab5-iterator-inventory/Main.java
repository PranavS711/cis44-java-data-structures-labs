public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();

        System.out.println("Adding numbers to the dynamic array");

        for (int i = 1; i <= 15; i++) {
            arr.add(i);
            System.out.println("Added " + i + "  Size is now " + arr.size());
        }

        System.out.println();
        System.out.println("Final array:");
        System.out.println(arr);
        System.out.println("Final size: " + arr.size());

        System.out.println();
        System.out.println("Testing get:");
        System.out.println("Item at index 0: " + arr.get(0));
        System.out.println("Item at index 10: " + arr.get(10));

        System.out.println();
        System.out.println("Testing remove:");
        System.out.println("Removed item at index 5: " + arr.remove(5));
        System.out.println("Array after removal:");
        System.out.println(arr);
        System.out.println("Size after removal: " + arr.size());
    }
}
