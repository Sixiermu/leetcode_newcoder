package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 剑指 Offer 45. 把数组排成最小的数 PriorityQueue小顶堆
 * @author: sixiermu
 * @time: 2022/8/19 10:42
 */
public class BaShuZhuPaiChengZuiXiaoDeShu {
        public String minNumber(int[] nums) {
            PriorityQueue<String> pq = new PriorityQueue(nums.length, new Comparator<String>(){
                @Override
                public int compare(String s1,String s2){
                    if((s1+s2).compareTo(s2+s1)>0){
                        return 1;
                    }else if((s1+s2).compareTo(s2+s1)<0){
                        return -1;
                    }
                    return 0;
                }
            });

            for(int num:nums){
                pq.offer(String.valueOf(num));
            }
            StringBuilder sb = new StringBuilder();
            while(!pq.isEmpty()){
                String s = pq.poll();
                sb.append(s);
            }
            return sb.toString();
        }
}
