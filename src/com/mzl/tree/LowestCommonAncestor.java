package com.mzl.tree;

public class LowestCommonAncestor {


    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // ------------ reach the end----------------

        // 1. reach the null end for each branch
        if (root == null) {
            return null;
        }
        // 2. reach the target end, no need to recursive the child
        if (root.val == p.val || root.val == q.val) {
            return root; // and return the target for each branch
        }

        // ------------ not reach the end----------------

        // 3. split the root to two branch and merge
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // merge是向上回溯的过程,这题的特点在于回溯是分情况的，return root or branch
        if (left != null & right != null) {
           return root; // 4. merge the branch for situation 1 : return root
        }
        // 5. merge the branch for situation 2: return either branch
        if (left == null) {
            return right;
        }
        return left;
    }
}
