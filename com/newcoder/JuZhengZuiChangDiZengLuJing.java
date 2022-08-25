package com.newcoder;
import java.util.*;
/**
 * @description: NC138矩阵最长递增路径
 * @author: sixiermu
 * @time: 2022/8/25 14:19
 */
public class JuZhengZuiChangDiZengLuJing {




        public int max = 0;
        public int solve (int[][] matrix) {
            // write code here
            for(int i=0;i<matrix.length;i++){

                for(int j=0;j<matrix[0].length;j++){
                    //新建数组很耗费时间？
                    //int [][] vi = new int[matrix.length][matrix[0].length];
                    dfs(i,j,0,Integer.MIN_VALUE,matrix);
                }
            }
            return max;
        }
        public void dfs(int i,int j,int cnt,int lastNum,int[][] matrix){
            if(i <0 || i>=matrix.length || j <0 || j>=matrix[0].length || matrix[i][j] <= lastNum ){
                return;
            }
            cnt++;
            //visited[i][j]=1;
            max = Math.max(cnt,max);
            dfs(i+1,j,cnt,matrix[i][j],matrix);
            dfs(i-1,j,cnt,matrix[i][j],matrix);
            dfs(i,j+1,cnt,matrix[i][j],matrix);
            dfs(i,j-1,cnt,matrix[i][j],matrix);
        }
}
