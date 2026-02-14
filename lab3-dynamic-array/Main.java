public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();

        // add a bunch so it has to resize
        for (int i = 1; i <= 15; i++) {
            arr.add(i * 10);
        }

        System.out.println("After adding 15 elements:");
        System.out.println("Array: " + arr);
        System.out.println("Size: " + arr.size());

        System.out.println("\nGet some values:");
        System.out.println("Index 0: " + arr.get(0));
        System.out.println("Index 5: " + arr.get(5));
        System.out.println("Last index: " + arr.get(arr.size() - 1));

        // remove from the middle to show shifting works
        int removed = arr.remove(4);
        System.out.println("\nRemoved index 4: " + removed);
        System.out.println("Array: " + arr);
        System.out.println("Size: " + arr.size());

        removed = arr.remove(0);
        System.out.println("\nRemoved index 0: " + removed);
        System.out.println("Array: " + arr);
        System.out.println("Size: " + arr.size());

        removed = arr.remove(arr.size() - 1);
        System.out.println("\nRemoved last element: " + removed);
        System.out.println("Array: " + arr);
        System.out.println("Size: " + arr.size());
    }
}

