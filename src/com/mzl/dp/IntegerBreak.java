package com.mzl.dp;

public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 这里需要比较拆分和不拆分i-j的结果，才能获得最优的解，也就是说dp的目的是
                // 是要优化每次的计算dp[i],所以是更新dp的过程，要充分考虑多种情况
                dp[i] = Math.max(dp[i], Math.max(j * dp[i-j], j * (i-j)));
                System.out.printf("dp[i]: %d, i: %d, j: %d \n", dp[i], i, j);
            }
        }
        return dp[n];
    }

}
