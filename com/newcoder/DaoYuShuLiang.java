package com.newcoder;

/**
 * @description: BM57 岛屿数量 dfs 或者查并集（find union   num parent cnt）
 * @author: sixiermu
 * @time: 2022/8/23 14:17
 */
public class DaoYuShuLiang {
    /**
     * 判断岛屿数量 dfs
     * @param grid char字符型二维数组
     * @return int整型
     */
//    public int solve (char[][] grid) {
//        // write code here
//        char[][] copy = new char[grid.length][grid[0].length];
//        for(int i=0;i<grid.length;i++){
//            for(int j =0;j<grid[0].length;j++){
//                copy[i][j] = grid[i][j];
//            }
//        }
//        int ret =0;
//        for(int i=0;i<copy.length;i++){
//            for(int j=0;j<copy[0].length;j++){
//                if(copy[i][j] == '1' ){
//                    ret++;
//                    dfs(i,j,copy);
//                }
//            }
//        }
//        return ret;
//    }
//    public void dfs(int i,int j,char[][] copy){
////         String info = String.format("dfs(%d ,%d)",i,j);
////         System.out.println(info);
//        if(i<0 || i>=copy.length || j<0 || j>=copy[0].length || copy[i][j]== '0'){
//            return ;
//        }
//        copy[i][j] = '0';
//        dfs(i+1,j,copy);
//        dfs(i-1,j,copy);
//        dfs(i,j+1,copy);
//        dfs(i,j-1,copy);
//    }
    /**
     * 判断岛屿数量 查并集
     * @param grid char字符型二维数组
     * @return int整型
     */
    private class DisjointSet {

        int[] parent;
        int jointNumber = 0;

        DisjointSet(int number) {
            parent = new int[number];
            for (int i = 0; i < parent.length ; i++) {
                parent[i] = i;
            }
          //  Arrays.fill(parent, -1);
        }
//查询并更新父亲
        int find(int n) {
            //int p = n;
            if(parent[n] == n){
                return n;
            }else{
                return parent[n] = find(parent[n]);
            }
//            while (parent[p] >= 0) {
//                p = parent[p];
//            }
//            int cur = n;
//            int temp;
//            // parent[cur] > 0 for initial is -1
//            while (parent[cur] >= 0 && parent[cur] != p) {
//                temp = parent[cur];
//                parent[cur] = p;
//                cur = temp;
//            }
           // return p;
        }
//用 '1' 的总数减去并查集中成功 union 的次数就是最后不连通的集合的个数。
        void union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);
            if (xParent == yParent)
                return;
            //合并 此处也可用于统计数目
            //parent[yParent] += parent[xParent];
            parent[xParent] = yParent;
            jointNumber++;
        }
    }

    public int numIslands(char[][] grid) {

        int row = grid.length;
        int column = grid[0].length;
        int lands = 0;

        DisjointSet disjointSet = new DisjointSet(row * column);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    lands++;
                    // right
                    if (j+1 < column && grid[i][j+1] == '1') {
                        disjointSet.union(i*column+j, i*column+j+1);
                    }
                    // under
                    if (i+1 < row && grid[i+1][j] == '1') {
                        disjointSet.union(i*column+j, (i+1)*column+j);
                    }
                }
            }
        }
        return lands - disjointSet.jointNumber;
    }
}
