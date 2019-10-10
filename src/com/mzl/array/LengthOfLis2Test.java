package com.mzl.array;

import org.junit.Assert;
import org.junit.Test;

public class LengthOfLis2Test {
    @Test
    public void TestLength() {
        Assert.assertEquals(4, new LengthOfLIS2().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18,11,34,10,6,8,24}));
    }
}
