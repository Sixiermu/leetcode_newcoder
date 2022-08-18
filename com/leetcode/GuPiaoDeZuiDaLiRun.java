package com.leetcode;

/**
 * @description: 剑指 Offer 63. 股票的最大利润;动规：保存当前日期前的最便宜买价
 * @author: sixiermu
 * @time: 2022/8/18 14:09
 */
public class GuPiaoDeZuiDaLiRun {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)return 0;
        int min = prices[0];
        int maxprofit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
                continue;
            }else{
                maxprofit = Math.max(maxprofit,prices[i]-min);
            }

        }
        return maxprofit;

    }
}
