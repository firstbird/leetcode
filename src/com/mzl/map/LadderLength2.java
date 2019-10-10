package com.mzl.map;

import java.util.*;

public class LadderLength2 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 一个队列存放当前层需要遍历的节点
        // 一个队列存放下一层需要遍历的节点
        // 当前层需要遍历的节点数为0时，交换队列用途
        // 和树的层次遍历差不多，是BFS
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Map<String, Boolean> used = new HashMap<>();
        int ans = 0;
        q1.offer(beginWord);

        while (q1.size() != 0 || q2.size() != 0) {
           ans++;
           while (q1.size() != 0) {
                String word = q1.poll();
                if (word.equals(endWord)) {
                    return ans;
                }
                for (String wd : wordList) {
                    // used不能再push到堆栈
                   if (!used.getOrDefault(wd, false) && isNeighbour(word, wd)) {
                       q2.offer(wd);
                       used.put(wd, true);
                   }
                }
           }
           ans++;
           while (q2.size() != 0) {
               String word = q2.poll();
               if (word.equals(endWord)) {
                   return ans;
               }
               for (String wd : wordList) {
                   // used不能再push到堆栈
                   if (!used.getOrDefault(wd, false) && isNeighbour(word, wd)) {
                       q1.offer(wd);
                       used.put(wd, true);
                   }
               }
           }
        }
        return 0;
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
