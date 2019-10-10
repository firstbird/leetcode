package com.mzl.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingPathTest {
    @Test
    public void test() {
        Assert.assertEquals(4, new LongestIncreasingPath().longestIncreasingPath(
                new int[][]{{9,9,4},{6,6,8},{2,1,1}}
        ));
    }
}
