package com.mzl.hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> abMap = new HashMap<>();
        for (int i = 0 ; i < A.length; i++) {
            for (int j = 0; j < B.length; j++){
                int sum = A[i] + B[j];
                abMap.put(sum, abMap.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j< D.length; j++){
                int sum = C[i] + D[j];
                count += abMap.getOrDefault(sum, 0);
            }
        }
        return count;
    }
}
