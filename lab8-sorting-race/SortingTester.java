import java.util.Random;
import java.util.Arrays;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- n = " + n + " ---");

            runAll("Average Case", generateRandomArray(n));
            runAll("Best Case", generateSortedArray(n));
            runAll("Worst Case", generateReverseSortedArray(n));
        }
    }

    public static void runAll(String caseType, int[] original) {
        System.out.println("\n" + caseType);

        int[] arr1 = Arrays.copyOf(original, original.length);
        int[] arr2 = Arrays.copyOf(original, original.length);
        int[] arr3 = Arrays.copyOf(original, original.length);

        // Selection Sort
        long start = System.nanoTime();
        SortingAlgorithms.selectionSort(arr1);
        long end = System.nanoTime();
        System.out.println("Selection Sort: " + (end - start) / 1e6 + " ms");

        // Insertion Sort
        start = System.nanoTime();
        SortingAlgorithms.insertionSort(arr2);
        end = System.nanoTime();
        System.out.println("Insertion Sort: " + (end - start) / 1e6 + " ms");

        // Merge Sort
        start = System.nanoTime();
        SortingAlgorithms.mergeSort(arr3);
        end = System.nanoTime();
        System.out.println("Merge Sort: " + (end - start) / 1e6 + " ms");
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
}
