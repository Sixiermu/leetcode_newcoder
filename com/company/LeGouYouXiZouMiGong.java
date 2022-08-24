package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description: 乐狗游戏 走迷宫问题dfs 注意输入、限制条件和回溯 用sout调试每一步
 * @author: sixiermu
 * @time: 2022/8/22 9:34
 */
public class LeGouYouXiZouMiGong {
    //设置类属性 全局使用 减少dfs参数
    public static ArrayList<Integer> hpArr;
    public static int[][] visited;
    public static int hp;
    public static void main(String[] args) {
        hp = 2;//ans = 1;
        hpArr = new ArrayList<>();
        int[][] cavet = new int[][]{
                {0,0,-3,0,0},
                {0,-1,-1,3,0},
                {-2,0,0,1,0},
        };
        visited = new int[3][5];
        int m = cavet.length;
        int n = cavet[0].length;
        //visited = new int[cave.length][cave[0].length];
        visited[2][0]=1;
        int i =2,j=0;
        dfs(cavet,2+1,0,3,5);
        dfs(cavet,2-1,0,3,5);
        dfs(cavet,2,0+1,3,5);
        dfs(cavet,2,0-1,3,5);

        Collections.sort(hpArr);
        if(hpArr.size() == 0){
            System.out.println(-1);
        }else{
            System.out.println(hpArr.get(hpArr.size()-1));
        }

    }

    //是否要重复走？
    //不重复走 需要回溯
    //记录已走过的路径
    public static void dfs(int[][] cave, int i,int j,int m,int n){
        //限制条件
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] == 1 || cave[i][j] == -1 || hp<=0 || cave[i][j] == -2){
            return;
        }
        //System.out.println("i=  "+i+"  j=  "+j + "   hp=" +hp);
        if(cave[i][j] == -3){
            //      System.out.println(1);
            hpArr.add(Integer.valueOf(hp));
            return;
        }
        hp = hp-cave[i][j];
        visited[i][j] = 1;
        //四个方向
        dfs(cave,  i, j+1, m, n);
        dfs(cave,  i-1, j, m, n);
        dfs(cave,  i, j-1, m, n);
        dfs(cave,  i+1, j, m, n);
        //回溯 !
        hp = hp + cave[i][j];
        visited[i][j] = 0;
    }
}
