package com.leetcode;
//43. 字符串相乘
/**
 * @description:
 * @author: sixiermu
 * @time: 2022/7/26 10:27
 */
public class ZiFuChuanXiangCheng {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))return "0";
        if(num1.length()>num2.length()){
            String tem = num2;
            num2 = num1;
            num1 = tem;
        }
        int len = num1.length();
        String[] strs = new String[len];
        for(int i=0;i<len;i++){
            int j = Integer.parseInt(num1.substring(i,i+1));
            if(j==0){
                strs[i]="0";continue;
            }
            String num = new String(num2);
            //乘法用加法代替
            while(j-->0){
                num = add(num,num2);
            }
            //10*用末尾补零
            int k = len-i-1;
            while (k-->0){
                //"+"  实际上调用的stringBuilder。append
                num = num + "0";
            }
            strs[i] = num;
        }
        String ret = new String();
        for (int i = 0; i < strs.length; i++) {
            ret = add(ret,strs[i]);
        }
        return ret;
    }
    /*public String add(String num1,String num2){
        if(num1.equals("0"))return num2;
        if(num2.equals("0"))return num1;
        StringBuilder ret = new StringBuilder();
        int carryflag = 0;
        StringBuilder n1 = new StringBuilder(num1);
        StringBuilder n2 = new StringBuilder(num2);
        while (n1.length()<n2.length()){
            n1.insert(0,'0');
        }
        while (n2.length()<n1.length()){
            n2.insert(0,'0');
        }
        int len = n1.length();
        while(len-->0){
            int a = Integer.parseInt(n1.substring(len,len+1)) + Integer.parseInt(n2.substring(len,len+1)) + carryflag;
            carryflag = a/10;
            ret.append(a%10);
        }
        if(carryflag==1)ret.append(1);
        return ret.reverse().toString();
    }*/
    public String add(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        //add!=0时
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
