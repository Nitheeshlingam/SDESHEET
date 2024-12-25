import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
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
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length -1;
        mergeSort(nums, 0, n);
        for(int i=0; i<=n; i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            for(int j=i+1; j<=n; j++){
                if(j>i+1 && nums[j]==nums[j-1])continue;
                int k = j+1;
                int l = n;
                while(k<l){
                    long sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;l--;
                        while(k<l && nums[k]==nums[k-1])k++;
                        while(k<l && nums[l]==nums[l+1])l--;
                    }
                    else if(sum < target)k++;
                    else l--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int [] nums = {2,2,2,2,2};
        List<List<Integer>> ans = fourSum(nums,8);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(0).size();j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
