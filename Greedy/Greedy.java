import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Greedy {

/* 
    static class Nmeetings{
    static class meeting{
        int start,end,pos;
        meeting(int start,int end,int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
    static class meetingComparator implements Comparator<meeting>{
        @Override
        public int compare(meeting o1, meeting o2){
            if (o1.end < o2.end) return -1;
            else if(o1.end > o2.end) return 1;
            else if(o1.pos < o2.pos) return -1;
            return 1;
        }
    }
public static int maxMeetings(int start[], int end[]) {
    ArrayList<meeting> meet = new ArrayList<>();
    int n = start.length;
    for(int i=0; i<n; i++){
        meet.add(new meeting(start[i],end[i],i+1));
    }
    meetingComparator mc = new meetingComparator();
    Collections.sort(meet, mc);
    ArrayList<Integer> answer = new ArrayList<>();
    int limit = meet.get(0).end; answer.add(meet.get(0).pos);int count = 1;
    for(int i=1; i<n;i++){
        if(meet.get(i).start > limit){
            count++;
            limit = meet.get(i).end;
            answer.add(meet.get(i).pos);
        }
    }
    return count;
}
    
}
*/
/* 
static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr); 
        Arrays.sort(dep); 
        int plat_needed = 1, result = 1; 
        int i = 1, j = 0, n = arr.length;  
        while (i < n && j < n) { 
        
            if (arr[i] <= dep[j]) { 
                plat_needed++; 
                i++; 
            } 
  
            else if (arr[i] > dep[j]) { 
                plat_needed--; 
                j++; 
            } 
  
            if (plat_needed > result) 
                result = plat_needed; 
        } 
  
        return result; 
}
*/
/*       
static class Pair{
    int id;
    int deadline;
    int profit;

    Pair(int id, int deadline,int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
        public static int findMax(int[]deadline,int n){
            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                if(max<deadline[i]) max = deadline[i];
            }
            return max;
        }

        public static ArrayList<Integer> JobSequencing(int[] id, int [] deadline, int [] profit) {
            int n = deadline.length;
            Pair [] pairs = new Pair[n];
            for(int i=0;i<n;i++){
                pairs[i] = new Pair(id[i],deadline[i],profit[i]);
            }
            Arrays.sort(pairs,(a,b)->Integer.compare(b.profit, a.profit));
            ArrayList<Integer> result = new ArrayList<Integer>();
            int maxDays = findMax(deadline,n);
            int []days = new int[maxDays];int jobs = 0,maxProfit = 0;
            for(Pair pair: pairs){
                int day = pair.deadline-1;
                while(day>=0){
                    if(days[day]==0){
                        days[day]=pair.id;
                        jobs++;maxProfit += pair.profit;
                        break;
                    }
                    day--;
                }
            }
            result.add(jobs);
            result.add(maxProfit);
            return result;
        }

        */

        static class Pair{
            int val, wt; double unitval;
            Pair(int val,int wt,double unitval){
                this.val = val;
                this.wt = wt;
                this.unitval = unitval;
            }
        }
        static double  fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
            double result = 0;
            int n = val.size();
            Pair pairs[] = new Pair[n];
            for(int i=0;i<n;i++){
                pairs[i] = new Pair(val.get(i), wt.get(i), (double)val.get(i)/wt.get(i));
            }
            Arrays.sort(pairs,(a,b)-> Double.compare(b.unitval,a.unitval));
            int i = 0;
            while(i<n){
                if(capacity>=pairs[i].wt){
                    capacity -= pairs[i].wt;
                    result+=pairs[i].val;
                }
                else{
                    result += (pairs[i].unitval * capacity);
                    break;
                }
                i++;
            }
            return result;
        }
    public static void main(String[] args) {
        List<Integer> val = new ArrayList<>(Arrays.asList(8,2,10,1,9,7,2,6,4,9));
        List<Integer> wt = new ArrayList<>(Arrays.asList(10,1,7,7,5,1,8,6,8,7));
        System.out.println(fractionalKnapsack(val,wt,21));
    }

}



