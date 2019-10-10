package com.mzl.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WiggleSort {

    public void wiggleSort(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);
        // 摆动穿插
        int n = nums.length;
        int high = n-1;
        int low = (n-1)/2; // 奇数个时，左侧少一个
        // 不能这样遍历，输入为【1,3,2,2,3,1】时，排序后为112233, 输出[1,3,1,3,2,2]
//        int high = n - 1;
//        int low = 0;
        // 也不能这样遍历, low序列的低位和high序列的低位还是可能相等的
//        int high = (n-1)/2;
//        int low = 0;
        for(int i=0;i<n;i++){
            if((i&1) == 1){
                nums[i] = list.get(high--);
            }else{
                nums[i] = list.get(low--);
            }
        }
    }
}
