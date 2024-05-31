package com.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagrams {

// https://medium.com/@digvijaygupta2143/count-occurrences-of-anagrams-sliding-window-61addbd446e2
    // https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5
public static int fineTotalNumberOfAnagrams(String text, String pat) {
    java.util.List<Integer> list = new ArrayList<Integer>();
    int i=0;
    int j=0;
    int k=pat.length();
    int ans=0;
    HashMap<Character , Integer> map = new HashMap<>();
    for(int l=0;l<pat.length();l++){
        map.put(pat.charAt(l) , map.getOrDefault(pat.charAt(l),0)+1);
    }
    int count=map.size();
    int n =text.length();
    while(j<n){
        char ch = text.charAt(j);
        if(map.containsKey(ch)){
            int val = map.get(ch);
            val=val-1;
            map.put(ch,val);
            if(map.get(ch)==0){
                count--;
            }
        }
        if(j-i+1<k){
            j++;
        }
        else if(j-i+1==k){
            if(count==0){
                ans ++;
            }
            if(map.containsKey(text.charAt(i))){
                map.put(text.charAt(i) , map.get(text.charAt(i))+1);

                if(map.get(text.charAt(i))==1){
                    count++;
                }
            }

            i++;
            j++;
        }
    }
    return ans;
}

    public static void main(String[] args) {
        System.out.println(fineTotalNumberOfAnagrams("abcdabcdabcd","abc"));

    }
}
