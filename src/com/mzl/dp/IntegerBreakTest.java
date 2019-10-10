package com.mzl.dp;

import org.junit.Assert;
import org.junit.Test;

public class IntegerBreakTest {

    @Test
    public void testIntegerBreak(){
        Assert.assertEquals(1,new IntegerBreak().integerBreak(2));
        Assert.assertEquals(8,new IntegerBreak().integerBreak(6));
        Assert.assertEquals(36,new IntegerBreak().integerBreak(10));
    }
}
