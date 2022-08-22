package com.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 美团基础题 小美和小团在玩游戏。小美将会给出n个大小在1到n之间的整数
 * @author: sixiermu
 * @time: 2022/8/19 16:09
 */
public class ZhaoShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //吃掉换行符号
        sc.nextLine();
        while(t>0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i]= sc.nextInt();
            }
            Arrays.sort(nums);
            if(k>=n){
                System.out.println("No");
            }else if(nums[k]>nums[k-1]){
                System.out.println("YES");
                System.out.println(nums[k-1]+1);
            }else {
                System.out.println("No");
            }
            sc.nextLine();
            --t;
        }
    }
}
