package com.leetcode;
//#814二叉树剪枝
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class ErChaShuJianZhi {

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
            if(root==null)return root;
            if(isContainsOne(root)==false)return null;
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            return root;
     }

    boolean isContainsOne(TreeNode root){
         if(root==null){
             return false;
         }
         if(root.val==1){
             return true;
         }else{
             return (isContainsOne(root.left) || isContainsOne(root.right));
         }
    }

    public static void main(String[] args) {
        String c = "a";
        String d = "a";
        String a = new String("a");
        String b = new String("a");


        System.out.println(a==c);
}

}
