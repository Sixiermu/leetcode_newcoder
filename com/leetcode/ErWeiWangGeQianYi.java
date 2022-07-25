package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//T1260 二维网格迁移
public class ErWeiWangGeQianYi {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length,n=grid[0].length;
        k = k % ( m * n);
        while(k-->0){
            grid=move(grid);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                a.add(grid[i][j]);
            }
            ret.add(a);
        }

        return  ret;
    }

    public int[][] move(int[][] A){
        int m = A.length,n= A[0].length;
        int[] copy = new int[m];
        copy[0] = A[m-1][n-1];
        for (int i = 1; i < m; i++) {
            copy[i] = A[i-1][n-1];
        }
        for (int i = n-1; i >= 1; i--) {
            for (int j = 0; j < m; j++) {
                A[j][i] = A[j][i-1];
            }
        }
        for (int i = 0; i < m; i++) {
            A[i][0] = copy[i];
        }
        return A;
    }
}
