public class ManualMergeSortIntervals {

    public static void main(String[] args) {
        // Input array of intervals
        int[][] intervals = {{1, 3}, {2, 6}, {2, 4}, {8, 9}, {8, 10}, {9, 19}};

        // Sort intervals using custom merge sort
        mergeSort(intervals, 0, intervals.length - 1);

        // Print the sorted intervals
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

    // Merge Sort Function
    public static void mergeSort(int[][] intervals, int start, int end) {
        if (start < end) {
            // Find the middle index
            int mid = start + (end - start) / 2;

            // Recursively sort the left half
            mergeSort(intervals, start, mid);

            // Recursively sort the right half
            mergeSort(intervals, mid + 1, end);

            // Merge the two sorted halves
            merge(intervals, start, mid, end);
        }
    }

    // Merge Function
    public static void merge(int[][] intervals, int start, int mid, int end) {
        // Determine sizes of the two subarrays
        int n1 = mid - start + 1;
        int n2 = end - mid;

        // Create temporary arrays to hold the data
        int[][] left = new int[n1][2];
        int[][] right = new int[n2][2];

        // Copy data to the temporary arrays
        for (int i = 0; i < n1; i++) {
            left[i][0] = intervals[start + i][0];
            left[i][1] = intervals[start + i][1];
        }
        for (int j = 0; j < n2; j++) {
            right[j][0] = intervals[mid + 1 + j][0];
            right[j][1] = intervals[mid + 1 + j][1];
        }

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (left[i][0] < right[j][0] || 
                (left[i][0] == right[j][0] && left[i][1] <= right[j][1])) {
                // Compare based on start; if same, compare based on end
                intervals[k][0] = left[i][0];
                intervals[k][1] = left[i][1];
                i++;
            } else {
                intervals[k][0] = right[j][0];
                intervals[k][1] = right[j][1];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left[], if any
        while (i < n1) {
            intervals[k][0] = left[i][0];
            intervals[k][1] = left[i][1];
            i++;
            k++;
        }

        // Copy remaining elements of right[], if any
        while (j < n2) {
            intervals[k][0] = right[j][0];
            intervals[k][1] = right[j][1];
            j++;
            k++;
        }
    }
}
