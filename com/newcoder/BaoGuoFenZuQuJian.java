package com.newcoder;
import java.util.Scanner;
/**
 * @description:美团 后台方向 2020校招 包裹区间分组
 * @author: sixiermu
 * @time: 2022/8/8 9:49
 */
public class BaoGuoFenZuQuJian {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String str=s.next();
        s.close();
        int start=0;
        int i=1;
        while(i<=str.length()){
            String temp=str.substring(start,i);
            int j=0;
            for(;j<temp.length();j++){
                if(str.indexOf(temp.charAt(j),i)>0){
                    break;
                }
            }
            if(j==temp.length()){
                start=i;
                System.out.print(temp.length()+" ");
            }
            i++;
        }
        return;
    }
}
