package com.slidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
// https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4
public class FirstNegativeNumberineveryWindowSizeK {
// First Negative Number in every Window of Size K | Sliding Window
public long[] printFirstNegativeInteger(long A[], int N, int K) {
    int i = 0;
    int j = 0;
    int ansIndex = 0;
    java.util.ArrayList<Long> list = new ArrayList<>();
    long[] ans = new long[N - K + 1];

    while (j < N) {
        if (A[j] < 0) {
            list.add(A[j]);
        }

        if (j - i + 1 < K) {
            j++;
        } else if (j - i + 1 == K) {
            if (!list.isEmpty()) {
                ans[ansIndex] = list.get(0);
            } else {
                ans[ansIndex] = 0;
            }
            ansIndex++;

            if (list.contains(A[i])) {
                list.remove(list.indexOf(A[i]));
            }
            i++;
            j++;
        }
    }

    return ans;
}

    public static void main(String[] args) {

    }
}
