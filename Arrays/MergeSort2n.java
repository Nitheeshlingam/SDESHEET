import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort2n {
     private static void mergeSort(int[][]array,int l,int mid,int r){
        int n1 = mid-l+1;
        int n2 = r-mid;
        int larr[][] = new int [n1][2];
        int rarr[][] = new int [n2][2];
        
        for(int x=0; x<n1; x++){
            larr[x][0] = array[x+l][0];
            larr[x][1] = array[x+l][1];
        }
        for(int x=0; x<n2; x++){
            rarr[x][0] = array[x+mid+1][0];
            rarr[x][1] = array[x+mid+1][1];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(larr[i][0]<rarr[j][0] || (larr[i][0]==rarr[j][0] && larr[i][1]<=rarr[j][1])){
                array[k][0]=larr[i][0];
                array[k][1]=larr[i][1];
                i++;
            }
            else{
                array[k][0]=rarr[j][0];
                array[k][1]=rarr[j][1];
                j++;
            }
            k++;
        }
        while(i<n1){
            array[k][0]=larr[i][0];
            array[k][1]=larr[i][1];
            i++;k++;
        }
        while(j<n2){
            array[k][0]=rarr[j][0];
            array[k][1]=rarr[j][1];
            j++;k++;
        }
    }
    private static void mergeSortarray(int[][] array,int l,int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSortarray(array, l, mid);
            mergeSortarray(array, mid+1, r);
            mergeSort(array,l,mid,r);
        }
    }
    public static int[][] merge(int[][] array) {
        int l=0,r=array.length-1;
        mergeSortarray(array, l, r);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<array.length;i++){
        if(ans.isEmpty()|| array[i][0]>ans.get(ans.size()-1).get(1)){
            ans.add(Arrays.asList(array[i][0],array[i][1]));
        }
        else{
            ans.get(ans.size()-1).set(1,array[i][1]>ans.get(ans.size()-1).get(1)?array[i][1]:ans.get(ans.size()-1).get(1));
        }
        }

        int rows = ans.size();
        int cols = 2;
        int[][] result = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                result[i][j]=ans.get(i).get(j);
            }
        }
        return result;
    }
    public static void main(String[]args){
        int array[][] = {{1,4},{4,5}};
        int[][] intervals = merge(array);
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
