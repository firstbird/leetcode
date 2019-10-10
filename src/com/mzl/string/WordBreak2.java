package com.mzl.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {
    Map<String, List<String>> res = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (res.containsKey(s)) {
           return res.get(s);
        }
        List<String> allCases = new ArrayList<>();
        if (wordDict.contains(s)) {
            allCases.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            if (!wordDict.contains(s.substring(0, i))){
                continue;
            }
            List<String> subStrList;
            String subString = s.substring(i, s.length());
            if (res.containsKey(subString)) {
                subStrList = res.get(subString);
            } else {
                subStrList = wordBreak(subString, wordDict);
            }
            if (subStrList.size() != 0) {
                List<String> newSubStrList = new ArrayList<>();
                for (int j = 0; j < subStrList.size(); j++) {
                    newSubStrList.add(s.substring(0, i) + ' ' +subStrList.get(j));
                }
                for (String str : newSubStrList) {
                    allCases.add(str);
                }
            }
        }
        res.put(s, allCases);
        return allCases;
    }
}
