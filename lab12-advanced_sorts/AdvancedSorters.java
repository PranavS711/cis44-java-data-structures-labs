import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    //  MERGE SORT 
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        // if size is 0 or 1 it's already sorted
        if (n < 2) return;

        // split array into two halves
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        // recursively sort both halves
        mergeSort(S1, comp);
        mergeSort(S2, comp);

        // merge them back together
        merge(S, S1, S2, comp);
    }

    private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator<K> comp) {
        int i = 0, j = 0, k = 0;

        // compare elements from both arrays and add smaller one
        while (i < S1.length && j < S2.length) {
            if (comp.compare(S1[i], S2[j]) <= 0) {
                S[k++] = S1[i++];
            } else {
                S[k++] = S2[j++];
            }
        }

        // copy remaining elements from S1
        while (i < S1.length) {
            S[k++] = S1[i++];
        }

        // copy remaining elements from S2
        while (j < S2.length) {
            S[k++] = S2[j++];
        }
    }


    //  QUICK SORT
    public static <K> void quickSort(K[] S, Comparator<K> comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    private static <K> void quickSort(K[] S, Comparator<K> comp, int a, int b) {
        // if subarray has 0 or 1 element
        if (a >= b) return;

        // partition and get pivot position
        int pivotIndex = partition(S, comp, a, b);

        // sort left and right sides
        quickSort(S, comp, a, pivotIndex - 1);
        quickSort(S, comp, pivotIndex + 1, b);
    }

    private static <K> int partition(K[] S, Comparator<K> comp, int a, int b) {
        // choose first element as pivot
        K pivot = S[a];

        int left = a + 1;
        int right = b;

        while (left <= right) {

            // move left pointer until bigger than pivot
            while (left <= right && comp.compare(S[left], pivot) <= 0) {
                left++;
            }

            // move right pointer until smaller than pivot
            while (left <= right && comp.compare(S[right], pivot) >= 0) {
                right--;
            }

            // swap if pointers haven't crossed
            if (left < right) {
                K temp = S[left];
                S[left] = S[right];
                S[right] = temp;
            }
        }

        // place pivot in correct position
        K temp = S[a];
        S[a] = S[right];
        S[right] = temp;

        return right; // final pivot index
    }
}
