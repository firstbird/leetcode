package com.mzl.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> sortedList = new ArrayList<>();
        int len = nums.length;
        Integer[] counts = new Integer[len];
        for (int i = len -1 ; i >= 0; i--) {
//            int count = 0;
//            for (int j = i+1; j < nums.length; j++) {
//               if (nums[j] < nums[i]) {
//                   count++;
//               }
//            }
            int left = 0;
            int right = sortedList.size();
            while (left < right) {
                int mid = left + (right - left)>>1;
                if (nums[i] <= sortedList.get(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            counts[i] = left;
            sortedList.add(left, nums[i]);
        }
        return Arrays.asList(counts);
    }
}
