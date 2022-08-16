package com.leetcode;

/**
 * @description: 剑指 Offer 49. 丑数 动态规划 用三个指针指向各自的较小丑数* 2 3 5
 * @author: sixiermu
 * @time: 2022/8/16 14:28
 */
public class UglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        //
        int p2=1,p3=1,p5=1;
        for(int i=2;i<=n;i++){
            //下一个丑数为p2 3 5 指向的较小丑数 * 2 3 5
            int next = Math.min(dp[p2]*2,dp[p3]*3);
            next = Math.min(next,dp[p5]*5);
            dp[i] =  next;
            if(dp[p2]*2 == dp[i]) p2++;
            if(dp[p3]*3 == dp[i]) p3++;
            if(dp[p5]*5 == dp[i]) p5++;
        }
        return dp[n];
    }
}
