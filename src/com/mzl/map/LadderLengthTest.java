package com.mzl.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LadderLengthTest {

    @Test
    public void TestPerfectSquare() {

        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        Assert.assertEquals(5, new LadderLength().ladderLength("hit", "cog", list));
    }
}
