package com.newcoder;

//导入包
import java.util.Scanner;
import java.util.Arrays;

public class ScannerTest {

    public static void main(String[] args) {


        //创建对象
        Scanner sc = new Scanner(System.in);
        //sc.nextLine(); 与next nextInt连用时 用来去掉结尾的enter
        //sc.nextLine();
        System.out.print("请输入第一个字符串：");
        String s1=sc.next(); //sc.next 从不是空格换行符是开始输获取有效的字符 遇到空格 换行时候停止
        sc.nextLine();//用来吃掉enter
        System.out.print("请输入第二个字符串：");
        String s2=sc.nextLine();
        System.out.println("输入的字符串是："+s1+" "+s2);
    }
}
