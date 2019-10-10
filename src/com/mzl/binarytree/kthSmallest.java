package com.mzl.binarytree;


import java.util.ArrayList;
import java.util.List;

public class kthSmallest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
      List<Integer> data = new ArrayList<>();
      ldr(root, data);
      return data.get(k-1);
    }

    private void ldr(TreeNode root, List<Integer> data) {
        if (root != null) {
            ldr(root.left, data);
            data.add(root.val);
            ldr(root.right, data);
        }
    }
}
