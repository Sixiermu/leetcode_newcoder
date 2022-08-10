package com.leetcode;

/**
 * @description: 重做 5. 最长回文子串 中心拓展法
 * @author: sixiermu
 * @time: 2022/8/10 10:40
 */
public class ZuiChangHuiWenZiChuan {
        public String longestPalindrome(String s) {
            int max =0;
            int start=0,end=0;
            if(s.length()==1)return s;
            for(int i=0;i<s.length()-1;i++){
                int[] a = getLongestPalindrome(s,i,i);
                int[] b = getLongestPalindrome(s,i,i+1);

                if(a[1]-a[0] > end-start){
                    end = a[1];
                    start = a[0];
                }
                if(b[1]-b[0] > end-start){
                    end = b[1];
                    start = b[0];
                }
            }

            return s.substring(start,end+1);
        }

        public int[] getLongestPalindrome(String s,int start,int end){
            if(s.charAt(start) != s.charAt(end))return new int[]{start,start};
            while(start>=0 && end  <s.length() && s.charAt(start) == s.charAt(end) ) {
                --start;
                ++end;
            }
            return new int[]{start+1,end-1};
        }

}
