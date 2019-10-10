package com.mzl.greedy;

import java.util.ArrayList;
import java.util.List;

public class Jumper {
    public boolean canJump(int[] nums) {
        List<Integer> validSteps = new ArrayList<>();
        int pos = 0;
        while(!isEnd(validSteps, nums)) {
            if (pos >= nums.length) {
                return false;
            }
            if (canReach(validSteps, nums, pos)) {
               validSteps.add(pos);
            }
            pos++;
        }
        return true;
    }


    private boolean isEnd(List<Integer> steps, int[] nums) {
        if (steps.size() == 0) {
            return false;
        }
        if (steps.get(steps.size() - 1) == nums.length -1) {
            return true;
        }
        return false;
    }

    private boolean canReach(List<Integer> steps, int[] nums, int pos) {
        if (steps.size() == 0 && pos == 0) {
            return true;
        }
        for (Integer i:steps) {
            if (i + nums[i] >= pos) {
                return true;
            }
        }
        return false;
    }

}
