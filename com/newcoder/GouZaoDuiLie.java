package com.newcoder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GouZaoDuiLie {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            Queue<Integer> queue = new LinkedList<>();
            int Q = scan.nextInt();
            for (int j = 0; j < Q; j++) {
                String str = scan.next();
                if (str.equals("PUSH")) {
                    int num = scan.nextInt();
                    queue.add(num);
                } else if (str.equals("TOP")) {
                    if (queue.size() > 0) {
                        System.out.println(queue.peek());
                    } else {
                        System.out.println(-1);
                    }
                }else if (str.equals("POP")) {
                    if (queue.size() > 0) {
                        queue.remove();
                    } else {
                        System.out.println(-1);
                    }
                } else if (str.equals("SIZE")) {
                    System.out.println(queue.size());
                }
                else if (str.equals("CLEAR")) {
                    queue.clear();
                }
            }
        }
        scan.close();
    }
}
