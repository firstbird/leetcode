package com.mzl.dp;

import org.junit.Assert;
import org.junit.Test;

public class PerfectSquareTest {


    @Test
    public void TestPerfectSquare() {
        Assert.assertEquals(1, new PerfectSquare().numSquares(1));
        Assert.assertEquals(2, new PerfectSquare().numSquares(2));
        Assert.assertEquals(3, new PerfectSquare().numSquares(3));
        Assert.assertEquals(1, new PerfectSquare().numSquares(4));
        Assert.assertEquals(1, new PerfectSquare().numSquares(9));
        Assert.assertEquals(2, new PerfectSquare().numSquares(13));
    }
}
