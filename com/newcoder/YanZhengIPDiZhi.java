package com.newcoder;
import java.util.*;

/**
 * @description: 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址
 * @author: sixiermu
 * @time: 2022/8/24 17:03
 */
public class YanZhengIPDiZhi {
    public String solve (String IP) {
        // write code here
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }
    public boolean isIPv4(String IP) {
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == '.') {
                continue;
            } else if (IP.charAt(i) < '0' ||  IP.charAt(i) > '9') {
                return false;
            }

        }
        String[] strs = IP.split("\\.",-1);
        if (strs.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (strs[i].length() == 1 && Integer.parseInt(strs[i]) >= 0) {
                continue;
            } else if (strs[i].length() == 2 && Integer.parseInt(strs[i]) >= 10) {
                continue;
            } else if (strs[i].length() == 3 && Integer.parseInt(strs[i]) >= 100
                    && Integer.parseInt(strs[i]) <= 255) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean isIPv6(String IP) {
        IP = IP.toLowerCase();
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == ':') {
                continue;
            } else if ((IP.charAt(i) >= '0' &&  IP.charAt(i) <= '9') ||
                    (IP.charAt(i) >= 'a' &&  IP.charAt(i) <= 'f')
            ) {
                continue;
            } else {
                return false;
            }
        }
        String[] strs = IP.split(":",-1);
        if (strs.length != 8)return false;
        for (int i = 0; i < 8; i++) {
            String s = strs[i];
            if (s.length() == 0) {
                return false;
            } else if (s.length() >= 2 && s.length() <= 4) {
                if (s.equals("00") || s.equals("00") || s.equals("0000")) {
                    return false;
                }
            } else if(s.length()>4){
                return false;
            }
        }
        return true;
    }
}
