import java.util.Arrays;

public class MergeSortExample {

    public static void main(String[] args) {
        int[] arr = {3,12,44,1,2,67,0};
        int[] sa = mergeSort(arr,0,arr.length - 1);
        System.out.print("Sorted Array -> ");
        Arrays.stream(sa).forEach(System.out::print);

    }

    public static int[] mergeSort(int[] arr,int low,int high) {
        if(low == high) {
            // putting the single element in a new array
            int [] res=new int[1];
            res[0]=arr[low];
            return res;
        }
        //dividing the array into 2 parts
        int mid = (low + high)/2;
        //sorting the left part recursively
        int [] ls=mergeSort(arr,low,mid);
        //sorting the right part recursively
        int[] rs=mergeSort(arr,mid+1,high);
        // merging the two parts
        int [] ans=mergeTwoSortedArrays(ls,rs);
        return ans;
    }

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        int p1 = 0, p2 = 0, p3 = 0;
        //creating the answer array that would contain the merged sorted elements
        int[] arr3 = new int[arr1.length + arr2.length];

        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] <= arr2[p2]) {
                arr3[p3] = arr1[p1];
                p1++;
                p3++;
            } else {
                arr3[p3] = arr2[p2];
                p2++;
                p3++;
            }
        }

        while (p1 < arr1.length) {
            arr3[p3] = arr1[p1];
            p3++;
            p1++;
        }

        while (p2 < arr2.length) {
            arr3[p3] = arr2[p2];
            p3++;
            p2++;
        }

        return arr3;
    }
}
