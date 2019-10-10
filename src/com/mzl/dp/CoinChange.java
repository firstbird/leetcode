package com.mzl.dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins.length  == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        Map<Integer, Integer> sums = new HashMap<>();
//        for (int i = 0; i < coins.length; i++) {
//            if (coins[i] == amount) {
//                return 1;
//            }
//            sums.put(coins[i], 1);
//        }
        return recursive(coins, sums, amount);

    }

    private int recursive(int[] coins, Map<Integer, Integer> sums, int amount) {
        if (sums.containsKey(amount)) {
            return sums.get(amount);
        }
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount > coins[i]) {
                int subSum = recursive(coins,sums, amount - coins[i]);
                if (subSum != -1)
                sum = Math.min(sum, 1 + subSum);
            } else if (amount == coins[i]) {
                sum = 1;
                break;
            }
        }
        if (sum == Integer.MAX_VALUE) {
            sums.put(amount, -1);
            return -1;
        }
        sums.put(amount, sum);
        return sum;
    }
}
