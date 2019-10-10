package com.mzl.binarytree;

import java.util.*;

public class BinaryTreeCodecWrong {

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root);
        while (q1.size() != 0 || q2.size() != 0) {
            while (q1.size() != 0) {
               TreeNode node = q1.poll();
               if (node != null) {
                   q2.offer(node.left);
                   q2.offer(node.right);
                   data.add(node.val);
               } else {
                   data.add(null);
               }
            }
            while (q2.size() != 0) {
                TreeNode node = q2.poll();
                if (node != null) {
                    q1.offer(node.left);
                    q1.offer(node.right);
                    data.add(node.val);
                } else {
                    data.add(null);
                }
            }
        }
        int len = data.size();
        if (len == 0) {
            return "";
        }
        for (int i = len -1; i >= 0 ; i--) {
            if (data.get(i) == null) {
                data.remove(i);
            } else {
                break;
            }
        }
        String res = data.toString().replaceAll(" ", "");
        System.out.println(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] dataArr = data.replace("[","").replace("]", "").split(",");
        if (dataArr.length == 0) {
            return null;
        }
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArr));
        return recursize(dataList);
    }

    private TreeNode recursize(List<String> dataList) {
        if (dataList.size() == 0) {
            return null;
        }
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
           return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = recursize(dataList);
        root.right = recursize(dataList);
        return root;
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
