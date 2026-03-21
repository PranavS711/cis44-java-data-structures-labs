public class MaxSubarraySolver {

    /**
     * Brute Force Approach
     * Time Complexity: O(n^2)
     *
     * Analysis:
     * Outer loop runs n times
     * Inner loop runs up to n times
     * Total operations ≈ n * n = n^2
     */
    public static int bruteForceMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;

            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];  // constant operation
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * Kadane's Algorithm
     * Time Complexity: O(n)
     *
     * Analysis:
     * Single loop over array → n iterations
     * Each step does constant work
     * Total = O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
