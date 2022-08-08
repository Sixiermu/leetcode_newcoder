package com.leetcode;

/**
 * @description: 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * @author: sixiermu
 * @time: 2022/8/12 14:50
 */
public class ZhengShuZhong1ChuXianCiShu {

/**
 * @description: 将数字分为 高位 低位 当前位 ，并记录当前位 位因子
 */
    public int countDigitOne(int n) {
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        int digit = 1;
        int ret = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                ret += high * digit;
            } else if (cur == 1) {
                ret += high * digit + low + 1;
            } else {
                ret += (high + 1) * digit;
            }
            cur = high % 10;
            high = high / 10;
            digit *= 10;
            low = n % digit;
        }
        return ret;
    }
}
