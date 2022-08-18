package com.leetcode;

/**
 * @description: 面试题13. 机器人的运动范围 dfs 注意数位条件 向右 向下递归即可
 * @author: sixiermu
 * @time: 2022/8/18 14:58
 */
public class JiQiRenYunDongFanWei {
    public int kk;
    public int ret =0;
    public int[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new int[m][n];
        this.kk=k;
        dfs(0,0,m,n);
        return ret;
    }
    public void dfs(int i,int j,int m,int n ){
        //越界 访问过 或不满足数位和
        if(i>=m || j >=n || visited[i][j] ==1 || sum(i,j)>kk){
            return ;
        }
        ret++;
        visited[i][j]=1;
        //向右
        dfs(i,j+1,m,n);
        //向下
        dfs(i+1,j,m,n);
    }

    public int sum(int i,int j){
        int x = 0;
        int y =0;
        while(i!=0){
            x += i%10;
            i = i/10;
        }
        while(j!=0){
            y += j%10;
            j = j/10;
        }
        return x+y;
    }
}
