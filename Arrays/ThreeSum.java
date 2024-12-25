import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class ThreeSum {
    private static void merge(int[] nums, int low, int mid, int high){
        int n1 = mid - low +1;
        int n2 = high - mid;

        int []lowarr = new int[n1];
        int []higharr = new int[n2];

        for(int x=0; x<n1; x++){
            lowarr[x] = nums[low+x];
        }
        for(int x=0; x<n2; x++){
            higharr[x] = nums[x+mid+1];
        }

        int i=0, j=0, k=low;

        while(i<n1 && j<n2){
            if(lowarr[i]<=higharr[j]){
                nums[k] = lowarr[i];i++;
            }
            else{
                nums[k] = higharr[j];j++;
            }
            k++;
        }

        while(i<n1){
            nums[k] = lowarr[i];i++;k++;
        }
        while(j<n2){
            nums[k] = higharr[j];j++;k++;
        }
    }
    private static void mergeSort(int[]nums, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(nums, low,mid);
            mergeSort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length -1;
        mergeSort(nums, 0, n);
        for(int i=0; i<=n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1, k = n;
        while(j<k){
            int sum = nums[i] + nums[j] + nums[k];
            if(sum<0) j++;
            else if(sum>0) k--;
            else{
                List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                ans.add(temp);
                j++;k--;
                while(j<k && nums[j]== nums[j-1])j++;
                while(j<k && nums[k]== nums[k+1])k--; 
            }
        }  
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(nums);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(0).size();j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
