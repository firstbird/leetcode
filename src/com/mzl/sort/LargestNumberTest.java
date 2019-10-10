package com.mzl.sort;

import org.junit.Assert;
import org.junit.Test;

public class LargestNumberTest {

    @Test
    public void testIntegerBreak(){
//        int[] arr = new int[]{41,23,87,55,50,53,18,9,39,63,35,33,54,25,26,49,74,61,32,81,97,99,38,96,22,95,35,57,80,80,16,22,17,13,89,11,75,98,57,81,69,8,10,85,13,49,66,94,80,25,13,85,55,12,87,50,28,96,80,43,10,24,88,52,16,92,61,28,26,78,28,28,16,1,56,31,47,85,27,30,85,2,30,51,84,50,3,14,97,9,91,90,63,90,92,89,76,76,67,55};
        int[] arr = new int[]{121, 12};
        Assert.assertEquals("12121",new LargestNumber().largestNumber(arr));
        int[] arr2 = new int[]{999999998,999999997,999999999};
        Assert.assertEquals("999999999999999998999999997",new LargestNumber().largestNumber(arr2));
    }
}
