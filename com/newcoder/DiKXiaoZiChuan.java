package com.newcoder;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DiKXiaoZiChuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        Set<String> set = new TreeSet<>();


        int len = s.length();
        for(int i=0;i<len;i++){
            for(int j = i; j<i+k && j<len;j++){
                set.add(s.substring(i,j+1));
            }
        }
        int i=0;
        for(String ans:set){
            i++;
            if(i==k){
                System.out.println(ans);
                break;
            }
        }

    }
}
