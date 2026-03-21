import java.util.Random;
import java.util.Arrays;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- n = " + n + " ---");

            int[] arr = generateRandomArrayWithNegatives(n);

            // Brute Force
            long start = System.nanoTime();
            int bruteResult = MaxSubarraySolver.bruteForceMaxSum(arr);
            long end = System.nanoTime();
            double bruteTime = (end - start) / 1e6;

            // Kadane
            start = System.nanoTime();
            int kadaneResult = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            end = System.nanoTime();
            double kadaneTime = (end - start) / 1e6;

            System.out.println("Brute Force: " + bruteTime + " ms");
            System.out.println("Kadane's Algorithm: " + kadaneTime + " ms");
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(2001) - 1000; // values between -1000 and 1000
        }

        return arr;
    }
}
