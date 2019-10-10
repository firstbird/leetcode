package com.mzl.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> chMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            chMap.put(s.charAt(i), chMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (chMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
