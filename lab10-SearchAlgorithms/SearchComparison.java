public class SearchComparison {

    /**
     * Linear search just checks every element one by one
     */
    public static int linearSearch(int[] arr, int key) {
        int comparisons = 0; // counts how many checks we do

        for (int i = 0; i < arr.length; i++) {
            comparisons++; // we are checking this index

            if (arr[i] == key) {
                System.out.println("Linear comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear comparisons: " + comparisons);
        return -1; // not found
    }

    /**
     * Binary search cuts the array in half each time
     * only works on sorted arrays
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == key) {
                System.out.println("Binary comparisons: " + comparisons);
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1; // go left
            } else {
                low = mid + 1; // go right
            }
        }

        System.out.println("Binary comparisons: " + comparisons);
        return -1; // not found
    }

    public static void main(String[] args) {
        int[] unsortedData = {22, 8, 12, 1, 9, 30, 4, 15};
        int[] sortedData =   {1, 4, 8, 9, 12, 15, 22, 30};

        System.out.println("--- Lab 1: Search Algorithm Implementation ---");

        // Linear search tests
        System.out.println("Linear Search (Unsorted):");
        System.out.println("Find 9: Index " + linearSearch(unsortedData, 9));
        System.out.println("Find 3: Index " + linearSearch(unsortedData, 3));

        // Binary search tests
        System.out.println("\nBinary Search (Sorted):");
        System.out.println("Find 9: Index " + binarySearch(sortedData, 9));
        System.out.println("Find 3: Index " + binarySearch(sortedData, 3));
        System.out.println("Find 30: Index " + binarySearch(sortedData, 30));
    }
}
