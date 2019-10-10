package com.mzl.array;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        // i 是每次遍历的终点, dp存储的是以i为终点的最长序列的长度
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // j 是上一个子串的终点的可能值
               if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
