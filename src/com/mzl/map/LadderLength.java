package com.mzl.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderLength {
    Map<String, List<String>> adjList;

    int maxLength = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return 0;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }
        initMap(wordList);

        maxLength = wordList.size();
        int minLength = maxLength + 2;
        for (String word: wordList) {
            if (isNeighbour(word, beginWord)) {
                if (word.equals(endWord)) {
                    return 2;
                }
                int length = dfs(word, endWord, 2);
                if (length != 1) {
                    minLength = Math.min(minLength, length);
                }
            }
        }
        return minLength < maxLength +2 ? minLength : 0;
    }

    private int dfs(String word, String endWord, int curLen) {
        if (curLen == maxLength + 1) {
            return -1;
        }

        int minLength = maxLength +2;
        for (String neighbour : adjList.getOrDefault(word, new ArrayList<String>())) {
            if (neighbour.equals(endWord)) {
                return curLen+1;
            }
            int tmpLen = dfs(neighbour, endWord, curLen +1);
            if (tmpLen != -1) {
                minLength  = Math.min(minLength, tmpLen);
            }
        }
        return minLength < maxLength +2 ? minLength : -1;
    }

    private void initMap(List<String> wordList) {
        adjList = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
               if (i != j && isNeighbour(wordList.get(i), wordList.get(j))) {
                  List<String> adj =  adjList.getOrDefault(wordList.get(i), new ArrayList<String>());
                  adj.add(wordList.get(j));
                  adjList.put(wordList.get(i), adj);
               }
            }
        }
    }

    private boolean isNeighbour(String a, String b) {
       if (a.equals(b)) {
           return false;
       }
       int diffNum = 0;
       for (int i = 0; i < a.length(); i++) {
          if (a.charAt(i) == b.charAt(i)) {
              continue;
          } else {
              diffNum++;
              if (diffNum > 1) {
                  return false;
              }
          }
       }
       return true;
    }
}
