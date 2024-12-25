
public class NextPermutation {
    private static void reverseArray(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void nextGreaterPermutation(int[] nums) {
        int n = nums.length;

        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            reverseArray(0, n - 1, nums);
            return;
        }

        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }

        reverseArray(ind + 1, n - 1, nums);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 3};
        nextGreaterPermutation(nums);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
    }
}
