package com.mzl.dp;

public class LengthOfLIS {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    int sum = Integer.MIN_VALUE;// 千万不能写0, 因为和可能小于0
    public int maxPathSum(TreeNode root) {
       if (root == null) {
         return 0;
       }
       count(root);
       return sum;
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(count(root.left), 0);// 核心代码， 如果count(root.left)是负数，那么左树就不要了
        int rightGain = Math.max(count(root.right), 0);// 同上
        sum = Math.max(root.val + leftGain + rightGain, sum);
        return root.val + Math.max(leftGain, rightGain);// 拆了一个树后还要返回一个结果作为被拆树的代替
    }
}
