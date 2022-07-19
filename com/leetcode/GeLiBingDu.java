package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//隔离病毒
public class GeLiBingDu {
    public static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        int[][] isinfected = {{1,1,1,0,0,0,0,0,0}, {1,0,1,0,1,1,1,1,1}, {1,1,1,0,0,0,0,0,0}};

        System.out.println(containVirus(isinfected));
    }

    public static int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int[][] settled = new int[55][55];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isInfected[i][j] == 1) settled[i][j] = 1;
            }
        }
        int ans = 0;
        while (true) {
            List<List<int[]>> list = findBlocks(isInfected);
            if (list.size() == 0) break;//没有病毒块
            //找病毒区域最大的区域
            int index = -1, max = -1, e = -1;
            for (int i = 0; i < list.size(); i++) {
                int[] a = countBlocks(list.get(i), isInfected, settled);
                if (max < a[1]) {
                    max = a[1];
                    index = i;
                    e = a[0];
                }
            }
            if (e == 0) {
                break;
            }
            //封锁
            ans +=e;
            List<int[]> locked=list.get(index);
            for (int i = 0; i < locked.size(); i++) {
                int[] a = locked.get(i);
                isInfected[a[0]][a[1]] = 0;
            }
            //list.remove(index);
            //其余病毒区域拓展
            for (int i = 0; i < list.size(); i++) {
                if (i == index) {continue;}
                List<int[]> l = list.get(i);
                for (int j = 0; j < l.size(); j++) {
                    //上下左右查找
                      int a[]=l.get(j);
                    for (int k = 0; k < 4; k++) {
                        int x = a[0]+dirs[k][0], y = a[1]+dirs[k][1];
                        if (x >= 0 && x < isInfected.length && y >= 0 && y < isInfected[0].length && settled[x][y] == 0) {
                            settled[x][y] = 1;
                            isInfected[x][y] = 1;
                        }
                    }
                }
            }

        }
        return ans;
    }

    public static int[] countBlocks(List<int[]> list,int grid[][],int settled[][]){
        //计算连通块与0的相邻边数，以及相邻的0的数量
        int ans[]=new int[2];//边、0
        int cameBefore[][]=new int[55][55];
        for(int i=0;i<list.size();i++){
            int a[]=list.get(i);
            for(int j=0;j<4;j++){
                int x=a[0]+dirs[j][0],y=a[1]+dirs[j][1];
                if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]==0&&settled[x][y]==0){
                    ans[0]++;
                    if(cameBefore[x][y]==0){
                        cameBefore[x][y]=1;
                        ans[1]++;
                    }
                }
            }
        }
        return ans;
    }
    public  static List<List<int[]>> findBlocks(int grid[][]){
        //提取每个病毒连区域
        int cameBefore[][]=new int[55][55];
        List<List<int[]>> ans=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&cameBefore[i][j]==0){
                    cameBefore[i][j]=1;
                    List<int[]> list=new ArrayList<>();
                    list.add(new int[]{i,j});
                    for(int k=0;k<list.size();k++){
                        int a[]=list.get(k);
                        for(int p=0;p<4;p++){
                            int x=a[0]+dirs[p][0],y=a[1]+dirs[p][1];
                            if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]==1&&cameBefore[x][y]==0){
                                list.add(new int[]{x,y});
                                cameBefore[x][y]=1;
                            }
                        }
                    }
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

