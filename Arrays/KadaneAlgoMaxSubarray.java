public class KadaneAlgoMaxSubarray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int sum=nums[0];int maxSum = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            System.out.println(maxSum);
            if(sum>maxSum) maxSum = sum;
            if(i==n) return maxSum;
            if((sum+nums[i]>=0 || sum+nums[i]>maxSum) && maxSum > nums[i]){
                sum += nums[i];
            }
            else if(maxSum < nums[i]){
                sum = nums[i];
            }
            else{
                sum = 0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {-2,1};
        int result = maxSubArray(arr);
        System.out.println(result);
    }
}
