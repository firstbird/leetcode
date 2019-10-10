package com.mzl.begin;

public class DropEgg {
    public int superEggDrop(int K, int N) {
        int i = 1;
        while (g(i, K) < N) {
            i++;
        }
        return i;
    }
    private int g(int i, int k) {
        if (i == 1) return 1;
        if (k == 1) return i;
        return g(i - 1, k - 1) + g(i - 1, k) + 1;

    }
}
