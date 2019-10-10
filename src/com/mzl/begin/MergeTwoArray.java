package com.mzl.begin;

import java.util.Arrays;

public class MergeTwoArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        int[] nums1Tmp = Arrays.copyOfRange(nums1, 0, m);
        int index = 0;
        while (index1 < m && index2 < n) {
            if (nums1Tmp[index1] <= nums2[index2]) {
                nums1[index++] = nums1Tmp[index1++];
            } else {
                nums1[index++] = nums2[index2++];
            }
        }
        if (index1 == m) {
           while (index < m +n ){
               nums1[index++] = nums2[index2++];
           }
        }
        if (index2 == n) {
            while (index < m +n ){
                nums1[index++] = nums1Tmp[index1++];
            }
        }

    }
}
