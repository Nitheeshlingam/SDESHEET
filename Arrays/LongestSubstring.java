import java.util.HashMap;
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, len = 0, n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        while(right < n){
            if(map.containsKey(s.charAt(right)))
            left = Math.max(map.get(s.charAt(right))+1,left);
            map.put(s.charAt(right),right);
            len = Math.max(len, right - left +1);
            right++;
        }
        return len;
    }
    public static void main(String[] args){
        String s = "pwwkew";
        int len = lengthOfLongestSubstring(s);
        System.out.print(len);
    }
}
