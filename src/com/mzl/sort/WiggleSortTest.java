package com.mzl.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class WiggleSortTest {
    @Test
    public void test() {
        int[] input = new int[]{1,5,1,1,6,4};
        new WiggleSort().wiggleSort(input);
        Assert.assertEquals(Arrays.toString(new int[]{1, 2}), Arrays.toString(input));
    }
}
