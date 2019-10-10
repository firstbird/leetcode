package com.mzl.array;

import java.util.Arrays;

public class MaxProduct {


    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxStore = new int[nums.length];
        maxStore[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int multi = nums[i];
            int multiMax = Integer.MIN_VALUE;
            for (int j = i-1; j >= 0; j--) {
                multi = multi * nums[j];
                multiMax = Math.max(multiMax, multi);
                if (i == 4) {
                    System.out.println("j: " + j);
                    System.out.println("multiMax: " + multiMax);
                }
            }
            maxStore[i] = Math.max(nums[i], Math.max(maxStore[i-1], multiMax));
        }
//        for (int i = 0; i < nums.length; i++) {
//           System.out.println(maxStore[i]);
//        }

        return maxStore[nums.length -1];
    }
}
