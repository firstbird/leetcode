package com.mzl.binarytree;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeCodec {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> nodes = new ArrayList<>();
        preInorder(root, nodes);
        String res = "";
        for (int i = 0;i < nodes.size(); i++) {
            res += nodes.get(i);
            if (i != nodes.size() -1){
                res += ",";
            }
        }
        return res;
    }


    private void preInorder(TreeNode root, List<String> nodes) {
        if (root == null) {
            nodes.add("null");
            return;
        }
        nodes.add(String.valueOf(root.val));
        preInorder(root.left, nodes);
        preInorder(root.right, nodes);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] nodes = data.split(",");
        if (nodes.length == 0) {
            return null;
        }
        List<String> list = new LinkedList<>(Arrays.asList(nodes));
        return recursive(list);
    }

    private TreeNode recursive(List<String> list) {
       if (list.get(0).equals("null")) {
           list.remove(0);
           return null;
       }
       // 递归也要保持先序
       TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
       list.remove(0);
       root.left = recursive(list);
       root.right = recursive(list);
       return root;
    }
}
