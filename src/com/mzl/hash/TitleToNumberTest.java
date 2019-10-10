package com.mzl.hash;

import org.junit.Assert;
import org.junit.Test;

public class TitleToNumberTest {
    @Test
    public void test() {
        Assert.assertEquals(1, new TitleToNumber().titleToNumber("A"));
    }
}
