package com.slidingWindow;

import java.util.*;

public class MaxSubArray {

// Maximum of all subarrays of size k

        //Function to find maximum of each subarray of size k.
        static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k)
        {
            // Your code here
            ArrayList<Integer> l = new ArrayList<>();
            Deque<Integer> q = new LinkedList<>();

            int left = 0, right = 0;
            while(right < n){
                while(q.size() > 0 && q.peekLast() < arr[right]){
                    q.removeLast();
                }
                q.add(arr[right]);


                if((right - left + 1) < k)
                    right++;

                else if((right - left + 1) == k){
                    l.add(q.peek());

                    right++;
                    if(q.peek() == arr[left]){
                        q.removeFirst();
                    }
                    left++;
                }
            }
            return l;
        }

    public static void main(String[] args) {
        int arr[] = { 1 ,2, 3, 1, 4, 5, 2, 3, 6 };
        int K = 3;
        int N = arr.length;

         max_of_subarrays(arr, N, K).forEach(System.out::println);

    }
}
