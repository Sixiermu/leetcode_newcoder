package com.newcoder;
import java.util.*;
/**
 * @description: BM74 数字字符串转化成IP地址  dfs+回溯
 * @author: sixiermu
 * @time: 2022/8/24 14:14
 */
public class ShuZiZiFuChuanZhuanIP {
    public ArrayList<String> ans;
    public ArrayList<String> restoreIpAddresses (String s) {
        // write code here
        this.ans = new ArrayList<>();
        if (s.length() < 4) return ans ;
        String ret = "";
        dfs(0, 0, s, ret);
        return ans;

    }
    public void dfs(int i, int k, String s, String ret) {
        if (k == 4 && s.equals("")) {
            ans.add(ret.substring(0, ret.length() - 1));
        }

        if (s.length() > 0 && s.substring(i, i + 1).compareTo("0") >= 0 ) {
            dfs(i, k + 1, s.substring(i + 1), ret + s.substring(i, i + 1) + ".");
        }
        if (s.length() > 1 && s.substring(i, i + 2).compareTo("10") >= 0 ) {
            dfs(i, k + 1, s.substring(i + 2), ret + s.substring(i, i + 2) + ".");
        }
        if (s.length() > 2 && s.substring(i, i + 3).compareTo("100") >= 0 &&
                s.substring(i, i + 3).compareTo("255") <= 0) {
            dfs(i, k + 1, s.substring(i + 3), ret + s.substring(i, i + 3) + ".");
        }
    }
}
