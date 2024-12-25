import java.util.Arrays;

public class RotateMatrixTranspose{

    // Rotate 90 degrees clockwise
    public static int[][] rotate90(int[][] matrix) {
        int m = matrix.length; // Rows
        int n = matrix[0].length; // Columns
        int[][] rotated = new int[n][m];

        // Transpose the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    // Rotate 180 degrees clockwise
    public static int[][] rotate180(int[][] matrix) {
        int m = matrix.length; // Rows
        int n = matrix[0].length; // Columns
        int[][] rotated = new int[m][n];

        // Reverse each row and transpose
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[m - 1 - i][n - 1 - j] = matrix[i][j];
            }
        }
        return rotated;
    }

    // Rotate 270 degrees clockwise
    public static int[][] rotate270(int[][] matrix) {
        int m = matrix.length; // Rows
        int n = matrix[0].length; // Columns
        int[][] rotated = new int[n][m];

        // Transpose the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[n - 1 - j][i] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}, 
            {10, 11, 12}
        };

        // Rotate by 90 degrees
        System.out.println("90 Degrees Rotation:");
        System.out.println(Arrays.deepToString(rotate90(array)));

        // Rotate by 180 degrees
        System.out.println("180 Degrees Rotation:");
        System.out.println(Arrays.deepToString(rotate180(array)));

        // Rotate by 270 degrees
        System.out.println("270 Degrees Rotation:");
        System.out.println(Arrays.deepToString(rotate270(array)));
    }
}
