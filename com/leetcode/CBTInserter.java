package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 919. 完全二叉树插入器
 * @author: sixiermu
 * @time: 2022/7/25 8:57
 */

class CBTInserter {
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
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        //层次遍历
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int i = deque.size();
            while(i-->0){
                TreeNode node = deque.poll();
                if(node.left != null){
                    deque.offer(node.left);
                }else{
                    node.left = new TreeNode(val);
                    return node.val;
                }
                if(node.right != null){
                    deque.offer(node.right);
                }else{
                    node.right = new TreeNode(val);
                    return node.val;
                }
            }
        }
        return root.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
