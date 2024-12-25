import java.util.ArrayList;
import java.util.List;
public class PascalNCR{

    private static Integer findNum(int n, int r){
        int result = 1;
        for(int i=0; i<r; i++){
            result = result * (n - i);
            result = result / (i+1);
        }
        return result;
    }

    private static List<Integer> pascalRow(int row){
        // List<Integer> result= new ArrayList<>();
        // for(int i=0;i<=row;i++){
        //     result.add(findNum(row,i)); Better
        // }
        int ans =1 ;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); //inserting the 1st element

        //calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
    private static List<List<Integer>> printPascal(int row){
        List<List<Integer>> pascaltriangle = new ArrayList<>();
        for(int i=1;i<=row;i++){
            pascaltriangle.add(pascalRow(i));
        }
        return pascaltriangle;
    }
    public static void main(String[] args) {
        // int number = findNum(6,0);
        // System.out.println(number);
        // List<Integer> row = pascalRow(7);
        // System.out.println(row);
        List<List<Integer>> pascalTriangle = printPascal(6);
        System.out.println(pascalTriangle);
    }
}