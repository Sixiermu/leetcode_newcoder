package com.leetcode;
//791. 自定义字符串排序
/**
 * @description:
 * @author: sixiermu
 * @time: 2022/7/23 11:24
 */
public class ZiDingYiZiFuChuanPaiXu {
    public String customSortString(String order, String s) {
        int[] charCnt = new int[26];
        for(char a:s.toCharArray()){
            charCnt[a-'a']++;
        }
        StringBuilder ret = new StringBuilder();
        for(int i = 0;i<order.length();i++){
            char a = order.charAt(i);
            for (int j = 0; j < charCnt[a-'a']; j++) {
                ret.append(a);
            }
            charCnt[a-'a']=0;
        }
        for (int i = 0; i < charCnt.length; i++) {
            if(charCnt[i]==0)continue;
            for (int j = 0; j < charCnt[i]; j++) {
                ret.append((char) ('a' + i));
            }
        }
        return ret.toString();
    }
}
