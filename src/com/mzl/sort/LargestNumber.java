package com.mzl.sort;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {


    public String largestNumber(int[] nums) {
        List<Integer> sortedNums = new ArrayList<>();
        sortedNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        sortedNums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String o1s = o1.toString();
                String o2s = o2.toString();
                String ss1 = o1s + o2s;
                String ss2 = o2s + o1s;
                int len = ss1.length();
                for (int i = 0; i < len; i++) {
                    if (ss1.charAt(i) == ss2.charAt(i)) {
                        continue;
                    }
                    return ss1.charAt(i) - ss2.charAt(i);
                }
                return 0;
            }
        });
        StringBuilder res = new StringBuilder();
        boolean isZero = false;
        int zeroNum= 0;
        for (int i = sortedNums.size() -1 ; i >=0 ; i--) {
            res.append(sortedNums.get(i));
        }
        String ss = res.toString();
        if (ss.replaceAll("0", "").equals("")) {
            return "0";
        }
        return res.toString();
    }

}
