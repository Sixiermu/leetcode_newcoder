package com.newcoder;
import java.util.Scanner;
//抛物线 =  与直线  =  +  所围成的封闭图形面积.若图形不存在,则输出
public class PaoWuXianYuZhiXianMianJi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int A=sc.nextInt();
            int B=sc.nextInt();
            int C=sc.nextInt();
            int a = B*B,b=(2*B*C-2*A),c = C*C;
            //判根
            if(b*b-4*a*c>=0){
                double x1 = (double) (-b + Math.sqrt(b*b-4.0*a*c))/2.0/a;
                double x2 = (double) (-b - Math.sqrt(b*b-4.0*a*c))/2.0/a;
                double y1 = B*x1 + C;
                double y2=  B*x2 + C;
                //整型数字的运算
                double ans = ((1.0/2.0*y1*y1-C*y1)/B - 1.0/3.0*y1*y1*y1/2.0/A - (1.0/2.0*y2*y2-C*y2)/B + 1.0/3.0*y2*y2*y2/2.0/A) ;
                System.out.println(Math.abs(ans));
            }else {
                System.out.println(0);
            }
        }
    }
}
