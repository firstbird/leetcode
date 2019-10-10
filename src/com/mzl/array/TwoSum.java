package com.mzl.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {

    List<Integer> numsList = new ArrayList<>();

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) {
            return new int[0];
        }
        numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < numsList.size(); i++) {
            int sedcondPos = foundOtherNum(i, target - numsList.get(i));
            if (sedcondPos != -1){
                result[0] = i;
                result[1] = sedcondPos;
                return result;
            }
        }
        return new int[0];
    }

    private int foundOtherNum(int firstPos, int j) {
        for (int i = 0; i < numsList.size(); i++) {
            if (i != firstPos && numsList.get(i) == j) {
                return i;
            }
        }
        return -1;
    }
}
