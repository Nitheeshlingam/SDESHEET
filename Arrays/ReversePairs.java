public class ReversePairs {
    private static void merge(int[] nums,int low, int mid, int high){
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
    private static int countPairs(int[] nums, int low,int mid, int high){
        int right = mid+1;
        int cnt = 0;
        for(int i=low; i<=mid; i++){
            while(right <= high && nums[i]>(long)2*nums[right])right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }
    private static int mergeSort(int[] nums, int low, int high){
        int cnt = 0;
        if(low>=high) return cnt;
        int mid = (low+high)/2;
        cnt+=mergeSort(nums,low,mid);
        cnt+=mergeSort(nums,mid+1,high);
        cnt+=countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return cnt;
    }
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0 ,nums.length-1);
    }
    public static void main(String[] args){
        int [] nums = {2,4,3,5,1};
        int count = reversePairs(nums);
        System.out.println(count);
    }
}
