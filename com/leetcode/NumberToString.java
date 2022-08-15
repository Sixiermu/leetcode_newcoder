package com.leetcode;

/**
 * @description: 剑指 Offer 46. 把数字翻译成字符串 动态规划
 * @author: sixiermu
 * @time: 2022/8/15 11:13
 */
public class NumberToString {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length()+1];
        dp[0]=1;
        for(int i=1;i<str.length();i++){
            if(str.substring(i-1,i+1).compareTo("10")>=0 &&
                    str.substring(i-1,i+1).compareTo("26")<0 ){
                if(i==1){
                    dp[i] = 2;
                }else{
                    dp[i] = dp[i-1] + dp[i-2];
                }

            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[str.length()-1];
    }
}
