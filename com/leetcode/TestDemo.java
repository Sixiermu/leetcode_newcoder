package com.leetcode;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @description:测试语法和类 接口等
 * @author: sixiermu
 * @time: 2022/7/29 15:22
 */
public class TestDemo implements Comparable<TestDemo>,Comparator<TestDemo>{
    public int a;

    public TestDemo() {
    }

    public TestDemo(int a) {
        this.a = a;
    }

    @Override
    public int compareTo(TestDemo o) {
        if(this.a - o.a>0) return 1;
        if(this.a - o.a<0) return -1;
        return 0;
    }

    @Override
    public int compare(TestDemo o1, TestDemo o2) {
        if(o1.a - o2.a>0) return -1;
        if(o1.a - o2.a<0) return 1;
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {5,2,3};


    }
}
