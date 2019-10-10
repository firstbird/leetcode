package com.mzl.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindWords {

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                char curCh = word.charAt(i);
                if (curNode.containsKey(curCh)) {
                    curNode = curNode.get(curCh);
                } else {
                    curNode.links[curCh - 'a'] = new TrieNode();
                    curNode = curNode.links[curCh - 'a'];
                }
            }
            curNode.setIsEnd();
            curNode.val = word;
        }
    }

    public class TrieNode {

        private TrieNode[] links;

        private static final int R = 26;

        private boolean isEnd;

        private String val;

        public TrieNode() {
            links = new TrieNode[R];
            isEnd = false;
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }
        public void setIsEnd() {
            isEnd = true;
        }
        public boolean getIsEnd() {
            return isEnd;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        //使用set防止重复
        Set<String> res =new HashSet<>();
//        List<String> res = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
               dfs(board, trie.root, i, j, row, col, res, visited);
            }
        }
        return new LinkedList<>(res);
    }

    private void dfs(char[][] board, TrieNode curNode, int i, int j, int row, int col,
                     Set<String> res, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= row || j >= col || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        char curChar = board[i][j];
        // 找出curChar对应的 TrieNode, 也就是TrieNode也会随着map的遍历而移动
        // 因为要找下一个char，要从curNode的children中找,所以curNode是要更新的
        curNode = curNode.get(curChar);
        if (curNode == null) {
            visited[i][j] = false;
            return;
        }
        if (curNode.isEnd) {
           res.add(curNode.val);
           //此时不能return,为了找更多单词
            // 找到单词后不能回退，因为可能是“ad” “addd”这样的单词得继续回溯
        }
        // curNode已更新
        dfs(board, curNode, i+1, j, row, col, res, visited);
        dfs(board, curNode, i-1, j, row, col, res, visited);
        dfs(board, curNode, i, j+1, row, col, res, visited);
        dfs(board, curNode, i, j-1, row, col, res, visited);
        visited[i][j] = false;
    }
}
