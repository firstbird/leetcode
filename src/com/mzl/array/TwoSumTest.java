package com.mzl.array;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void testTwoSum() {
        int[] res1 = new TwoSum().twoSum(new int[]{1,2,3,3}, 6);
        Assert.assertEquals(2,  res1[0]);
        Assert.assertEquals(3,  res1[1]);
        Assert.assertEquals(0, new TwoSum().twoSum(new int[]{1,2,3}, 6).length);
        int[] res3 = new TwoSum().twoSum(new int[]{1,2,4,8}, 10);
        Assert.assertEquals(1,  res3[0]);
        Assert.assertEquals(3,  res3[1]);
    }
}
