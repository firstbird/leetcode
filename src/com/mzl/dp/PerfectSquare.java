package com.mzl.dp;

public class PerfectSquare {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; //1
        dp[1] = 1; //1

        for (int i = 2; i <=n ; i++) {
            dp[i] = i;
            for (int j =1; j*j <= i; j++) {
                // 移动方程并不是前后两项的关系，而是dp[i]自我的迭代更新,向着目标（最大或最小）更新,也就是遍历所有情况，取最优值，
                // 遍历的每种情况其实都是一个dp的子问题dp[k], 至于k是什么就不一定了，最优值在更新时，需要有一个待比较的表达式，这个
                // 表达式f(dp[k])必然包含子问题dp[k] ;所以dp问题的核心就是f(dp[k])的构造
                dp[i] = Math.min(dp[i], (dp[i - j * j]) + 1);
//                System.out.printf("i: %d, j: %d, dp[i]: %d \n", i, j, dp[i]);
            }
        }
        return dp[n];
    }
}
