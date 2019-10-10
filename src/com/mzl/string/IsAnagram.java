package com.mzl.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        Map<Character, Integer> chs1 = new HashMap<>();
        Map<Character, Integer> chs2 = new HashMap<>();
        Set<Character> keys = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            chs1.put(s.charAt(i), chs1.getOrDefault(s.charAt(i), 0) + 1);
            chs2.put(t.charAt(i), chs2.getOrDefault(t.charAt(i), 0) + 1);
            keys.add(s.charAt(i));
        }
        if (chs1.size() != chs2.size()) {
            return false;
        }
        for (Character ch: keys) {
            // 注意比较Integer用equals
            if (!chs1.get(ch).equals(chs2.get(ch))) {
                return false;
            }
        }
        return true;
    }
}
