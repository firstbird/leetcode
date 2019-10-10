package com.mzl.hash;

import java.util.*;

public class RandomizedSet {
    Set<Integer> set;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<Integer>();
        list = new LinkedList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return list.add(val) && set.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return list.remove(new Integer(val)) && set.remove(val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
