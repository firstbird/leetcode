package com.mzl.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestConsecutinveTest {
    @Test
    public void TestLongestConsecutive() {
        Assert.assertEquals(4, new LongestConsecutive().longestConsecutive(new int[]{100,4,200,1,3,2}));
        Assert.assertEquals(2, new LongestConsecutive().longestConsecutive(new int[]{0,-1}));
        Assert.assertEquals(3, new LongestConsecutive().longestConsecutive(new int[]{1,2,0,1}));
        Assert.assertEquals(3, new LongestConsecutive().longestConsecutive(
                new int[]{2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645}));
    }
}
