package com.newcoder;
import java.util.*;
import java.lang.StringBuilder;
/**
 * @description: [编程题]没有重复项数字的全排列 dfs+回溯
 * @author: sixiermu
 * @time: 2022/8/23 14:08
 */
public class MeiYouChongFuShuZiDeShuoYouPaiLie {

        public HashSet<String> hs;
        public int[] visited;

        public ArrayList<ArrayList<Integer>> permute(int[] num) {
            this.hs = new HashSet<>();
            this.visited = new int[num.length];
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
            dfs(num,0,"",arr,ret);
            //System.out.println(hs.size());
            //ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
            // for(int i=0;i<hs.size())
            return ret;
        }

        public void dfs(int[] num,int i,String s,ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> ret){
            if(i>=num.length){
                //hs.add(s);
                ret.add(new ArrayList(arr));
                return;
            }
            for(int j=0;j<num.length;j++){
                if(visited[j]==1){
                    continue;
                }
                //s = s + String.valueOf(j);
                visited[j] =1;
                arr.add(num[j]);
                dfs(num,i+1,s,arr,ret);
                //回溯
                //s = s.substring(0,s.length()-1);
                visited[j]=0;
                arr.remove(arr.size()-1);
            }
        }
}
