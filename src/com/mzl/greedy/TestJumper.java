package com.mzl.greedy;

import org.junit.Assert;
import org.junit.Test;

public class TestJumper {

    @Test
    public void testJumper() {
        Assert.assertEquals(true, new Jumper().canJump(new int[]{2,3,1,1,4}));
    }
}
