package com.mzl.sort;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return num;
            } else {
                set.add(num);
            }
        }
        return 0;
    }
}
