package com.mzl.begin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Zhongshu {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++ ) {
            if (map.containsKey(nums[i])) {
                map.put(new Integer(nums[i]), map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        int sumMax = 0;
        int maxNum = 0;
        while(entries.hasNext()){
            Map.Entry<Integer, Integer> entry = entries.next();
            if (entry.getValue() > sumMax) {
                sumMax = entry.getValue();
                maxNum = entry.getKey();
            }
        }
        return maxNum;
    }
}
