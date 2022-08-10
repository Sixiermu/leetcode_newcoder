package com.leetcode;

/**
 * @description: 大疆面试，最大收益
 * @author: sixiermu
 * @time: 2022/8/7 21:13
 */
public class ZuiDaShouYi {
    public static void main(String[] args) {
        int[] num = {2,7,1,3,5,55,100};
        //冷冻期
        int dp0=0;
        //非冷冻期
        int dp1=0;
        int max =0;
        for(int i=0;i<num.length;i++){

            int dp00 = num[i] + dp1;
            dp1 = Math.max(dp0,dp1);
            dp0 = dp00;
        }
        System.out.println(Math.max(dp0,dp1));
    }
}
