public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int ele = -1, cnt = 0;
        for(int num:nums){
            if(cnt == 0){
                ele = num;
                cnt++;
            }
            else if(ele == num) cnt++;
            else if(ele !=num){
                cnt--;
            }
        }
        return ele;
    }
    public static void main(String[]args){
        int[] array = {3,2,3};
        System.out.println(majorityElement(array));
    }
}
