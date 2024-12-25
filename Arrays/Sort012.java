public class Sort012 {
    private static void swap(int[]nums,int mid,int lrh){
        int temp = nums[mid];
        nums[mid]=nums[lrh];
        nums[lrh] = temp;
    }
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,mid,low);
                low++;mid++;
            }
            else if(nums[mid]==1)mid++;
            else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int []array = {2,0,2,1,1,0};
        sortColors(array);
        for(int num: array){
            System.out.print(num);
        }
    }
}
