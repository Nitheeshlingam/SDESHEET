import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Recursion{
    
    /* 
    public static void subsets(int index,int sum,int[] arr,ArrayList sumSubsets,int N){
        if(index == N){
            sumSubsets.add(sum);
            return;
        }
        //pick
        subsets(index+1,sum+arr[index],arr,sumSubsets,N);
        //dont pick
        subsets(index+1,sum,arr,sumSubsets,N);
    }
    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> sumSubsets = new ArrayList<>();
        subsets(0,0,arr,sumSubsets,arr.length);
        Collections.sort(sumSubsets);
        return sumSubsets;
    }
    */
    /* 
    public static void findSubsets(int ind, int [] nums,List<Integer> ds,List<List<Integer>> ans,int n){
        ans.add(new ArrayList<>(ds));
        for(int i = ind; i<n; i++){
            if(i!=ind && nums[i]==nums[i-1])continue;
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ans, n);
            ds.remove(ds.size()-1);
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n =  nums.length;
        findSubsets(0,nums,new ArrayList<>(),ans,n);
        return ans;
        
    }
        */
/* 
    public static void findSubsets(int ind,int []arr, List<Integer> ds, List<List<Integer>> ans, int n, int target){
          if(ind == n){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
          }
          if(arr[ind]<= target){
            ds.add(arr[ind]);
            findSubsets(ind, arr, ds, ans, n, target-arr[ind]);
            ds.remove(ds.size()-1);
          }
          findSubsets(ind+1, arr, ds, ans, n, target);
        }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        findSubsets(0,candidates,new ArrayList<>(),ans,n,target);
        return ans;
    }
        */

/* 
        public static void findSubsets(int ind,int []nums, List<Integer> ds, List<List<Integer>> ans, int n, int target){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
                return;
            }
            if(ind == n){
                return;
              }
            for(int i = ind; i<n; i++){
                if(i!=ind && nums[i]==nums[i-1])continue;
                if (nums[i] > target) break;
                ds.add(nums[i]);
                findSubsets(i+1, nums, ds, ans, n,target-nums[i]);
                ds.remove(ds.size()-1);
            }
          }
      
      public static List<List<Integer>> combinationSum(int[] candidates, int target) {
          Arrays.sort(candidates);
          List<List<Integer>> ans = new ArrayList<>();
          int n = candidates.length;
          findSubsets(0,candidates,new ArrayList<>(),ans,n,target);
          return ans;
      }

      */ 
      /* 
      public static void partitionHelper(int ind,String s,List<String> path,List<List<String>> res,int n){
        if(ind == n){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=ind; i<n; i++){
            if(isPalindrome(ind,i,s)){
                path.add(s.substring(ind,i+1));
                partitionHelper(i+1, s, path, res, n);
                path.remove(path.size()-1);
            }
        }
      }
      public static boolean isPalindrome(int start,int end,String s){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
            return false;
        }
        return true;
      }
      public static List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        partitionHelper(0, s, new ArrayList<>(), res, n);
        return res;
      }*/
    
      public static String getPermutation(int n, int k) {
        
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        String ans = "";
        for(int i=1; i<n; i++){
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        k=k-1;
        while(true){
            ans += numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size()==0) break;
            k = k % fact;
            fact = fact /  numbers.size();
        }
        return ans;
      }
        public static void main(String[] args) {
            System.out.println((getPermutation(3,3)));
        }
}
