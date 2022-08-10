package com.leetcode;

/**
 * @description: 动态规划 重做剑指 Offer 47. 礼物的最大价值
 * @author: sixiermu
 * @time: 2022/8/10 10:21
 */
public class LiWuZuiDaJiaZhi {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //
        for (int i=1;i<n;i++){
            grid[0][i] = grid[0][i] + grid[0][i-1];
        }
        for (int i=1;i<m;i++){
            grid[i][0] = grid[i][0] + grid[i-1][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j] = grid[i][j] + Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return  grid[m-1][n-1];
    }
}
