package com.newcoder;

import java.util.*;

//现在有 105 个用户，编号为 1- 105，现在已知有 m 对关系，每一对关系给你两个数 x 和 y ，代表编号为 x 的用户和编号为 y 的用户是在一个
//        圈子中，例如： A 和 B 在一个圈子中， B 和 C 在一个圈子中，那么 A , B , C 就在一个圈子中。现在想知道最多的一个圈子内有多少个用户。
public class ChaBingJi {

    private static int[] fa = new int [100005];
    private static int[] cnt = new int [100005];

    private  static int findf(int k){
        if(fa[k]!=k){
            return fa[k]=findf(fa[k]);
        }else{
            return k;
        }
    }

    public static void main(String[] args) {
        int ret = 1;
        Arrays.fill(cnt,1);
//        for(int i=0;i<fa.length;i++){ fa[i]=i;}
        Scanner scan = new Scanner(System.in);
        int m= scan.nextInt();
        while(m-->0){
            int n = scan.nextInt();
            Arrays.fill(cnt,1);
            ret = 1;
            for(int i=0;i<fa.length;i++){ fa[i]=i;}
            while(n-->0){
                int i = scan.nextInt();
                int j = scan.nextInt();
                i = findf(i);
                j = findf(j);
                if(i!=j){
                    fa[i] =j;
                    cnt[j]+=cnt[i];
                }
                ret = Math.max(ret,cnt[j]);
            }
            System.out.println(ret);
    }
    }
}
