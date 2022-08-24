package com.newcoder;
import java.util.*;
import java.lang.*;
/**
 * @description: nc26 ：括号生成 dfs+回溯
 * @author: sixiermu
 * @time: 2022/8/23 14:10
 */

public class KuoHaoShengCheng {
        public ArrayList<String> ret;
        public StringBuilder sb;
        public ArrayList<String> generateParenthesis (int n) {
            // write code here
            this.ret = new ArrayList<String>();
            this.sb = new StringBuilder();
            dfs(0,0,"",n);
            return ret;
        }

        public void dfs(int left,int right,String s,int n){
            String info = String.format("dfs(%d,%d)",left,right);
            System.out.println(info);
            if(left==n && right == n){
                ret.add(sb.toString());
                // sb.
                return;
            }
            if(left<n){
                sb.append("(");
                dfs(left+1,right,s+"(",n);
                sb.deleteCharAt(sb.length()-1);
            }
            if(right<left){
                sb.append(")");
                dfs(left,right+1,s+")",n);
                sb.deleteCharAt(sb.length()-1);

            }
        }
}
