package com.mzl.fenzhi;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LongestSubstring {

    public int longestSubstring(String s, int k) {
        if (s.equals("")) {
            return 0;
        }
        if (k > s.length()) {
            return 0;
        }
        int len = s.length();
        int p = 0;
        int q = len -1;
        return count(s.toCharArray(), k, p, q);
    }

    private int count(char[] chars, int k, int p, int q) {
        if (q - p +1 < k) {
            return 0;
        }
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = p; i <= q; i++) {
            charCount.put(chars[i], charCount.getOrDefault(chars[i], 0) + 1);
        }
        while (q - p + 1 >=k && charCount.get(chars[p]) < k) {
            p++;
        }
        while (q - p + 1 >=k && charCount.get(chars[q]) < k) {
            q--;
        }
        if (q - p +1 < k) {
            return 0;
        }
        for (int i = p; i <= q; i++) {
            // 找到第一个切割点就行了，因为往下迭代还可以切割
            if (charCount.get(chars[i]) < k) {
                return Math.max(count(chars, k, p, i-1), count(chars, k, i+1, q));
            }
        }

        return q -p +1;
    }
}
