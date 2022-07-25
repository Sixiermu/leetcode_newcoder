package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Q1424 对角线遍历2
public class DuiJiaoXianBianLi {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> notOrder = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> rowList = nums.get(i);
            for (int j = 0; j < rowList.size(); j++) {
                notOrder.add(new int[]{i+j,j,rowList.get(j)});
            }
        }
        Collections.sort(notOrder, (a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        });
        int[] ret = new int[notOrder.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i]=notOrder.get(i)[2];
        }
        return ret;
    }
}
