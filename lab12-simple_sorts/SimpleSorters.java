import java.util.Comparator;

public class SimpleSorters {

    /**
     * Bubble sort with optimization
     * stops early if no swaps happen
     */
    public static <K> void bubbleSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        // go through array multiple times
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // track if anything changed

            // compare adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                // if current is bigger than next, swap them
                if (comp.compare(S[j], S[j + 1]) > 0) {
                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;

                    swapped = true;
                }
            }

            // if nothing swapped, array already sorted
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Insertion sort
     * kinda like sorting cards in your hand
     */
    public static <K> void insertionSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 1; i < n; i++) {
            K cur = S[i]; // current element
            int j = i - 1;

            // shift elements that are bigger than cur
            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            // put cur in correct spot
            S[j + 1] = cur;
        }
    }
}
