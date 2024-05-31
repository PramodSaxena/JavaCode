package com.slidingWindow;

public class MaximumSumSubarrayofsizeK {
// fixed type Maximum Sum Subarray of size K | Sliding Window
    public static int maxSumSubArray(int[] nums,int size,int k) {
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0, sum = 0;
        while (j < size ){
            sum = sum + nums[j];
            if(j-i + 1 < k){
                j++;
            } else if (j - i+1 == k) {
                max = Math.max(max,sum);
                sum = sum - nums[i];
                i++;
                j++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int K = 4;
        int N = arr.length;

        int result = maxSumSubArray(arr, N, K);

        System.out.println(result);
    }
}
