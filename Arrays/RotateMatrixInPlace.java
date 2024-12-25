import java.util.Arrays;

public class RotateMatrixInPlace {
    // Helper to transpose the matrix
    public static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // Reverse rows for 90 degrees rotation
    public static void reverseRows(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            while (low < high) {
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
    }

    // Reverse columns for 270 degrees rotation
    public static void reverseColumns(int[][] matrix) {
        int n = matrix.length;
        int low = 0, high = n - 1;
        while (low < high) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[low][i];
                matrix[low][i] = matrix[high][i];
                matrix[high][i] = temp;
            }
            low++;
            high--;
        }
    }

    // Rotate 90 degrees clockwise
    public static void rotate90InPlace(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }

    // Rotate 180 degrees clockwise
    public static void rotate180InPlace(int[][] matrix) {
        reverseRows(matrix);
        reverseColumns(matrix);
    }

    // Rotate 270 degrees clockwise (90 degrees counterclockwise)
    public static void rotate270InPlace(int[][] matrix) {
        transpose(matrix);
        reverseColumns(matrix);
    }

    // Print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        System.out.println("\n90 Degrees Clockwise:");
        rotate90InPlace(matrix);
        printMatrix(matrix);

        System.out.println("\n180 Degrees Clockwise:");
        rotate180InPlace(matrix);
        printMatrix(matrix);

        System.out.println("\n270 Degrees Clockwise:");
        rotate270InPlace(matrix);
        printMatrix(matrix);
    }
}
