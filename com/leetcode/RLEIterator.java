package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

//900. RLE 迭代器
public class RLEIterator {
    int[][] codingNums;
    long nextTime = 0L;
    public RLEIterator(int[] encoding) {
        int len = encoding.length;
        codingNums = new int[len/2][2];// [][0] 次数 [][1]数字
        for (int i = 0; i < len; i+=2) {
            codingNums[i/2][0] = encoding[i];
            codingNums[i/2][1] = encoding[i];
        }
    }

    public int next(int n) {
        nextTime = nextTime + n;
        long tmp = 0L;
        for (int i = 0; i < codingNums.length; i++) {
            tmp+=codingNums[i][0];
            if(nextTime<=tmp){
                return codingNums[i][1];
            }
        }
        return -1;
    }
}
