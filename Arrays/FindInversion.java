public class FindInversion {
    private static long merge(long arr[],int l,int mid,int r){
        int n1 = mid - l+1;
        int n2 = r - mid;

        long cnt = 0;
        long larr[] = new long[n1];
        long rarr[] = new long[n2];

        for(int x=0; x<n1; x++){
            larr[x] = arr[x+l];
        }
        for(int x=0; x<n2; x++){
            rarr[x] = arr[x+mid+1];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(larr[i]<=rarr[j]){
                arr[k]=larr[i];
                i++;
            }
            else{
                arr[k]=rarr[j];
                cnt += (mid - l + 1 - i);
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=larr[i];
                i++;k++;
        }
        while(j<n2){
            arr[k]=rarr[j];
                j++;k++;
        }
        return cnt;
    }
    private static long mergeSort(long arr[],int l,int r){
        long cnt = 0;
        if(l>=r) return cnt;
        int mid = (l+r)/2;
        cnt+=mergeSort(arr,l,mid);
        cnt+=mergeSort(arr, mid+1, r);
        cnt+=merge(arr,l,mid,r);

        return cnt;
    }
    public static long getInversions(long arr[], int n) {
        return mergeSort(arr,0,n-1);
    }
    public static void main(String[]args){
        long [] array = {2,5,1,3,4};
        long count = getInversions(array,array.length);
        System.out.println(count);
    }
}
