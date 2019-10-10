package com.mzl.sort;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            int mid = left + ((right - left)>>1);
            if (isPeak(nums, mid)) {
                return mid;
            }
            if (mid+1 < nums.length && nums[mid +1] > nums[mid]) {
                left = mid +1;
            } else if (mid -1 >= 0 && nums[mid -1] > nums[mid]) {
                right = mid -1;
            } else {
                break;
            }
        }
        return -1;
    }

    private boolean isPeak(int[] nums, int mid) {
        int leftValue = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid -1];
        int rightValue = mid + 1 >= nums.length ? Integer.MIN_VALUE : nums[mid + 1];
        if (nums[mid] > leftValue && nums[mid] > rightValue) {
            return true;
        }
        return false;
    }
}
