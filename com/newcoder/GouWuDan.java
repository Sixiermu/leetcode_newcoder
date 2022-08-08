package com.newcoder;

import java.util.Scanner;

/**
 * @description: 牛客 HJ16 购物单 动态规划、背包问题
 * @author: sixiermu
 * @time: 2022/8/13 9:30
 */
public class GouWuDan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int money = sc.nextInt();
            int m = sc.nextInt();
            int[][] wights = new int[m + 1][3];
            int[][] values = new int[m + 1][3];
            money /= 10;
            sc.nextLine();
            for (int i = 1; i <= m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                a /= 10;
                //主
                if (c == 0) {
                    wights[i][0] = a;
                    values[i][0] = a * b;
                } else if (wights[c][1] == 0) {//附1
                    wights[c][1] = a;
                    values[c][1] = a * b;
                } else { //附2
                    wights[c][2] = a;
                    values[c][2] = a * b;
                }
                sc.nextLine();
            }
            int[][] dp = new int[m + 1][money + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= money; j++) {
                    int a = wights[i][0];
                    int b = values[i][0];
                    int c = wights[i][1];
                    int d = values[i][1];
                    int e = wights[i][2];
                    int f = values[i][2];
                    //选四个中的最大值
                    //判断能否足够购买主件
                    int max = j - a >= 0 ? Math.max(dp[i - 1][j], dp[i - 1][j - a] + b) : dp[i - 1][j];
                    //主 + 附1
                    max = j - a - c >= 0 ? Math.max(max, dp[i - 1][j - a - c] + b + d) : max;
                    //主 + 附2
                    max = j - a - e >= 0 ? Math.max(max, dp[i - 1][j - a - e] + b + f) : max;
                    //主 + 附1+ 附2
                    max = j - a - c - e >= 0 ? Math.max(max, dp[i - 1][j - a - e - c] + b + d + f) : max;
                    dp[i][j] = max;
                }
            }

            System.out.println(dp[m][money] * 10);

        }
        sc.close();
    }
}
