public class MergeSort {
    private static void merge(int[] array,int l,int mid,int r){
        int n1 = mid-l+1;
        int n2 =r-mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int x=0;x<n1;x++){
            left[x] = array[x+l];
        }
        for(int x=0;x<n2;x++){
            right[x] = array[x+mid+1];
        }

        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                array[k]=left[i];
                i++;
            }
            else{
                array[k]=right[j];
                j++;
            }
            k++;
        }

            while(i<n1){
                array[k]=left[i];
                i++;k++;
            }
            while(j<n2){
                array[k]=right[j];
                j++;k++;
            }
    }
    private static void mergeSort(int[] array,int l,int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(array,l,mid);
            mergeSort(array, mid+1, r);
            merge(array,l,mid,r);
        }
    }
    public static void main(String[]args){
        int[] array = {8,5,4,3,1,6,7};
        for(int num: array){
            System.out.print(num+" ");
        }
        System.out.println();
        System.out.println("Array is Sorting..");

        mergeSort(array,0,array.length-1);
        for(int num:array){
            System.out.print(num+" ");
        }
    }
}
