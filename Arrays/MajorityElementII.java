import java.util.List;
import java.util.ArrayList;
public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> majority = new ArrayList<>();
        int n= nums.length;
        int cnt1 = 0, cnt2 = 0, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        for(int num: nums){
            if(cnt1 ==0 && ele2 != num){
                ele1 = num;cnt1++;
            }
            else if(cnt2 ==0 && ele1 != num){
                ele2 = num;cnt2++;
            }
            else if(ele1 == num)cnt1++;
            else if(ele2 == num)cnt2++;
            else{
                cnt1--;cnt2--;
            }
        }
        cnt1=0;cnt2=0;
        for(int num: nums){
            if(ele1 == num) cnt1++;
            if(ele2 == num) cnt2++;
        }
        int mini = (int)(n/3);
        if(cnt1 > mini && cnt2 > mini){
            if(ele1<ele2){
                majority.add(ele1);majority.add(ele2);
            }
            else{
                majority.add(ele2);majority.add(ele1);
            }
        }
        else if(cnt1>mini){
            majority.add(ele1);
        }
        else if(cnt2>mini){
            majority.add(ele2);
        }
        return majority;
    }
    public static void main(String[] args){
        int[] nums = {3,2,3};
        List<Integer> result = majorityElement(nums);
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
