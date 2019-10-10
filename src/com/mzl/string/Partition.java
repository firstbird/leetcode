package com.mzl.string;

import java.util.ArrayList;
import java.util.List;

public class Partition {


    class Solution {
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> partition(String s) {

            return part(s, 0);
        }

        // start 表示字问题涉及的字符串的起始位置
        private List<List<String>> part(String s, int start){
            if (start == s.length()){
                List<String> list = new ArrayList<>();
                List<List<String>> lists = new ArrayList<>();
                lists.add(list);
                return lists;
            }
            List<List<String>> lists = new ArrayList<>();
            // 找多个起始split点
            for (int i = start; i < s.length(); i++) {
               if (isPalindrome(s.substring(start, i+1))){
                   String left = s.substring(start, i + 1);
                   // 子问题处理
                   List<List<String>> subLists = part(s, i+1);
                   //遍历后边字符串的所有结果，将当前的字符串加到头部
                   // 结果合并
                   for (List<String> l : subLists) {
                       l.add(0, left);
                       lists.add(l);
                   }
               }
            }
            return lists;

        }

        private boolean isPalindrome(String s) {
            int i = 0;
            int j = s.length() -1;
            while (i < j) {
               if (s.charAt(i) != s.charAt(j)){
                   return false;
               }
               i++;
               j--;
            }
            return true;
        }
    }
}
