public class Bineary2D {
    
    private static boolean BinearySearch2D(int[][] matrix, int target){
        int n = matrix.length, m= matrix[0].length;
        int low = 0, high = m*n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int rowIdx = mid / m, colIdx = mid % m;
            if(matrix[rowIdx][colIdx]==target)return true;
            else if(matrix[rowIdx][colIdx]<target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(BinearySearch2D(matrix, 13));
    }
}
