package com.newcoder;
import java.util.*;
/**
 * @description: NC184 判断是不是二叉搜索树 中序遍历
 * @author: sixiermu
 * @time: 2022/8/25 14:14
 */
public class PanDuanErChaSouSuoShu {

      private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }

        public boolean isValidBST (TreeNode root) {
            // write code here
            if(root==null)return true;
            ArrayList<Integer> res = new ArrayList<>();
            midOrder(res,root);
            int max = res.get(0);
            for(int i=1;i<res.size();i++){
                if(res.get(i)>max){
                    max = res.get(i);
                }else{
                    return false;
                }
            }
            return true;
        }

        public void midOrder(ArrayList<Integer> res,TreeNode root){
            if(root==null)return;

            midOrder(res,root.left);
            res.add(root.val);
            midOrder(res,root.right);
        }

}
