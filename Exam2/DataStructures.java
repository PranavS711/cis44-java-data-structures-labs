import java.util.*;

public class DataStructures {

    // 
    // 1. RECURSION
    //
    /**
     * Calculates the nth Fibonacci number using recursion.
     * The sequence goes: 0, 1, 1, 2, 3, 5, 8...
     */
    public static int recursiveFibonacci(int n) {
        // Base cases: these stop the recursion
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Recursive step: sum of the two previous numbers
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    // 
    // 2. ANALYSIS OF ALGORITHMS
    // 
    /**
     * Finds the second largest number in the array in one pass.
     */
    public static int findSecondMax(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        // Go through the array once
        for (int num : arr) {
            if (num > max) {
                // shift current max down
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }

        return secondMax;
    }

    // 
    // 3. TREES
    // 
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Returns the sum of only the leaf nodes.
     */
    public static int sumLeafNodes(Node root) {
        // If nothing is there, return 0
        if (root == null) return 0;

        // If it's a leaf node (no children), return its value
        if (root.left == null && root.right == null) {
            return root.value;
        }

        // Otherwise, recurse on left and right
        return sumLeafNodes(root.left) + sumLeafNodes(root.right);
    }

    // 
    // 4. SEARCH ALGORITHMS
    //
    /**
     * Binary search on a sorted array.
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        // Keep searching while valid range exists
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid - 1; // search left half
            } else {
                low = mid + 1; // search right half
            }
        }

        return -1; // not found
    }

    // 
    // 5. SORTING ALGORITHMS
    //
    /**
     * Selection sort: repeatedly finds the smallest element and swaps it.
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Go through each position in the array
        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            // Find the smallest element in the remaining unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap once per pass
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // 
    // TEST DRIVER (Do not modify)
    // 
    public static void main(String[] args) {
        System.out.println("=== Coding Advanced Data Structures ===\n");

        int fibN = 6;
        int expectedFib = 8;
        int actualFib = recursiveFibonacci(fibN);
        printTestResult("1. Recursion (Fibonacci)", expectedFib, actualFib);

        int[] numbers = {10, 5, 20, 8, 15};
        int expectedSecondMax = 15;
        int actualSecondMax = findSecondMax(numbers);
        printTestResult("2. Analysis (Second Max)", expectedSecondMax, actualSecondMax);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        int expectedLeafSum = 7;
        int actualLeafSum = sumLeafNodes(root);
        printTestResult("3. Trees (Leaf Sum)", expectedLeafSum, actualLeafSum);

        int[] sortedData = {1, 2, 4, 7, 9};
        int target = 7;
        int expectedIndex = 3;
        int actualIndex = binarySearch(sortedData, target);
        printTestResult("4. Search (Binary)", expectedIndex, actualIndex);

        int[] sortData = {64, 25, 12, 22, 11};
        String expectedSort = "[11, 12, 22, 25, 64]";
        selectionSort(sortData);
        String actualSort = Arrays.toString(sortData);

        System.out.println("[Test 5] Sorting (Selection Sort)");
        System.out.println(" Expected: " + expectedSort);
        System.out.println(" Actual: " + actualSort);

        if (expectedSort.equals(actualSort)) {
            System.out.println(" Result: [PASS]");
        } else {
            System.out.println(" Result: [FAIL]");
        }
        System.out.println();
    }

    private static void printTestResult(String testName, int expected, int actual) {
        System.out.println("[Test] " + testName);
        System.out.println(" Expected: " + expected);
        System.out.println(" Actual: " + actual);
        if (expected == actual) {
            System.out.println(" Result: [PASS]");
        } else {
            System.out.println(" Result: [FAIL]");
        }
        System.out.println();
    }
}
