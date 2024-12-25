import java.util.Arrays;

public class RotateNoTransPose {
    public static int[][] rotate90(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static int[][] rotate180(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] rotated = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[n - 1 - i][m - 1 - j] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static int[][] rotate270(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[m - 1 - j][i] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        
        System.out.println("Original Matrix:");
        printMatrix(array);

        System.out.println("\n90 Degrees:");
        printMatrix(rotate90(array));

        System.out.println("\n180 Degrees:");
        printMatrix(rotate180(array));

        System.out.println("\n270 Degrees:");
        printMatrix(rotate270(array));
    }
}
