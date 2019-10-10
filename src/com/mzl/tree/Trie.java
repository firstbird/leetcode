package com.mzl.tree;

public class Trie {
    private TrieNode root;

    public class TrieNode {

        private TrieNode[] links;

        private static final int R = 26;

        private boolean isEnd;

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

    /** Initialize your data structure here. */
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
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char curCh = word.charAt(i);
            if (curNode.containsKey(curCh)) {
                curNode = curNode.get(curCh);
            } else {
                return false;
            }
        }
        return curNode.getIsEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curCh = prefix.charAt(i);
            if (curNode.containsKey(curCh)) {
                curNode = curNode.get(curCh);
            } else {
                return false;
            }
        }
        return true;
    }

}
