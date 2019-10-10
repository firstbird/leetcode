package com.mzl.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        });
        List<Integer> listTemp = new ArrayList();
        for(Integer item: list){
            if(!listTemp.contains(item)){
                listTemp.add(item);
            }
        }
        int start = 0;
        int i = start + 1;
        int max = 1;
        while (i < listTemp.size()) {
            if (listTemp.get(i) == listTemp.get(i-1) + 1) {
            } else {
                max = Math.max(max, i- start);
                start = i;
            }
            i++;
        }
        max = Math.max(max, i- start);
        return max;
    }
}
