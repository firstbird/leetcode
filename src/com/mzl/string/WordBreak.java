package com.mzl.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    Map<String, Boolean> res = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            boolean subStrCanBreak = false;
            String subString = s.substring(i, s.length());
            if (res.containsKey(subString)) {
                subStrCanBreak = res.get(subString);
            } else {
                subStrCanBreak = wordBreak(subString, wordDict);
                res.put(subString, subStrCanBreak);
            }
            if (wordDict.contains(s.substring(0, i)) && subStrCanBreak) {
                return true;
            }
        }
        return false;
    }
}