package com.mzl.hash;

import java.util.*;

public class RandomizedCollection {
    Map<Integer, List<Integer>> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = true;
        if (map.containsKey(val)) {
            res = false;
        }
        List<Integer> newList = map.getOrDefault(val, new ArrayList<>());
        newList.add(val);
        map.put(val, newList);
        list.add(val);
        return res;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        List<Integer> tmpList = map.get(val);
        tmpList.remove(new Integer(val));
        if (tmpList.size() == 0) {
            map.remove(val);
        } else {
            map.put(val, tmpList);
        }
        list.remove(new Integer(val));
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
