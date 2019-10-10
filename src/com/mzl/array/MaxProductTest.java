package com.mzl.array;

import org.junit.Assert;
import org.junit.Test;

public class MaxProductTest {
    @Test
    public void test() {
        Assert.assertEquals(11, new MaxProduct().maxProduct(new int[]{2,-5,-2,-4,3}));
    }
}
