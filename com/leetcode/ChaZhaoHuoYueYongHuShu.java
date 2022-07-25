package com.leetcode;

import java.util.*;

//1817. 查找用户活跃分钟数
public class ChaZhaoHuoYueYongHuShu {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        //去重
        Arrays.sort(logs, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        logs = removeRepeat(logs);

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int[] a : logs) {
            if (a[0] == -1) continue;
            hm.put(a[0], hm.getOrDefault(a[0], 0) + 1);
        }


        int[] ret = new int[k];
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int a = entry.getValue();
            if (a <= k) {
                ret[a - 1]++;
            }

        }
        return ret;
    }

    public int[][] removeRepeat(int[][] logs) {
        int[] a = {logs[0][0], logs[0][1]};
        for (int i = 1; i < logs.length; i++) {
            if (logs[i][0] == a[0] && logs[i][1] == a[1]) {
                logs[i][0] = -1;
                logs[i][1] = -1;
            } else {
                a[0] = logs[i][0];
                a[1] = logs[i][1];
            }
        }
        return logs;
    }
}
