package com.mzl.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfLIS2 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
//        List<Integer> tails = new ArrayList<>();
        int[] tails = new int[nums.length];
        Arrays.fill(tails, 0);
//        for (int i = 0; i < nums.length; i++) {
//           tails.add(0);
//        }
        int end = 0;
        for (int k = 0; k < nums.length; k++) {
            int left = 0;
            int right = end;
//            System.out.println("============start");
//            System.out.printf("left: %d ,right: %d \n", left, right);
            while (left < right) {
                int mid = (left + right) / 2;
//                System.out.printf("mid: %d \n", mid);
//                System.out.printf("after left: %d ,right: %d \n", left, right);
                if (nums[k] <= tails[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
//                System.out.printf("after left: %d ,right: %d \n", left, right);
            }
//            System.out.printf("left: %d ,right: %d \n", left, right);
//            System.out.println("============end");
            tails[left] = nums[k];
            if (end == left) end++;
        }
        return end;
    }
}
