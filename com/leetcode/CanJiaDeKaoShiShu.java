package com.leetcode;

import org.openjdk.jol.vm.VM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @description: 最多参加得考试数  智商为g=2 ，考试序列： 8，7，1，2，2，3 ，选择参加得时机，大于智商则智商减一
 * @author: sixiermu
 * @time: 2022/7/28 10:43
 */
public class CanJiaDeKaoShiShu {
    public static void solution(){
        int[] a = {1,1,1,1,1,1,7,7,7,1,1,1,7,7,8,8};
        int iq = 2;
//        int n = a.length-1;
//        int sum=0,nq = 0;
//        for (int i = n; i >=0 ; i--) {
//            if(a[i]<=nq) sum++;
//            else if(nq<iq){
//                ++nq;
//                sum++;
//            }
//        }
        int ptr = 0,right = a.length-1;
        for(;right>=0;right--){
            if(ptr<a[right])
                ptr++;
            if(ptr == iq)
                break;
        }
        System.out.println(a.length - right);
        //System.out.println(sum);
    }

    public static void main(String[] args) {
//        //实际上是缓存中的同一个对象
//        Integer i =123;
//        Integer j = Integer.valueOf(123);
//        System.out.println(VM.current().addressOf(i));
//        System.out.println(VM.current().addressOf(j));
    }
}
