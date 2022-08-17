package com.leetcode;

/**
 * @description: 剑指 Offer 60. n个骰子的点数 动态规划 dp[i][j]表示i个骰子和为j的概率
 * @author: sixiermu
 * @time: 2022/8/17 15:18
 */
public class TouZiDeDianShu {
    public double[] dicesProbability(int n) {
        double[][] dp = new double[n+1][n*6+1];
        //第一颗骰子
        for(int i=1;i<=6;i++){
            dp[1][i] = 1.0/6.0;
        }
        if(n==1)return new double[]{1.0/6,1.0/6,1.0/6,1.0/6,1.0/6,1.0/6};
        //dp [i][j] 表示 i颗骰子和为j的概率
        //骰子数 从第二颗骰子开始
        for(int i=2;i<=n;i++){
            for(int j=i;j<=6*i;j++){
                for(int k=1;k<=6;k++){
                    if(j-k==0)break;
                    dp[i][j] += dp[i-1][j-k]*1.0/6;
                }

            }
        }
        System.out.println(dp[2][2]);
        double[] ret = new double[n*6-n+1];
        for(int i=n;i<=6*n;i++){
            ret[i-n] = dp[n][i];
        }
        return ret;
    }
}
