package com.leetcode;

import java.util.Stack;

/**
 * @description: leetcode 592. 分数加减运算
 * @author: sixiermu
 * @time: 2022/7/27 14:06
 */
public class FenShuJiaJianYunSuan {

        public String fractionAddition(String expression) {
            Stack<String> stack = new Stack<>();
            int p1=1,p2=0;
            expression = expression + "+";
            //提取操作数
            for(;p1<expression.length();p1++){
                if(expression.charAt(p1)=='+' || expression.charAt(p1)=='-'){
                    stack.push(expression.substring(p2,p1));
                    p2=p1;
                }
            }
            String ret = "0/1";
            while (!stack.isEmpty()){
                ret = addition(ret,stack.pop());
                //System.out.println(ret);
            }
            //约分
            int a = Integer.parseInt(ret.split("/")[0]);
            int b = Integer.parseInt(ret.split("/")[1]);
            int max = Math.min(Math.abs(a),Math.abs(b));
            if(a==0)return "0/1";
            while (max>1){
                if(a%max == 0 && b%max == 0)break;
                max--;
            }
            return String.valueOf(a/max) + "/" + String.valueOf(b/max);
        }

        public String addition(String s1,String s2){
            String[] o1 = s1.split("/");
            String[] o2 = s2.split("/");
            if(o1[1].equals(o2[1]))
            {
                return String.valueOf(Integer.parseInt(o1[0])+Integer.parseInt(o2[0])) +
                        "/" + o1[1];
            }
            return  String.valueOf(Integer.parseInt(o1[0])*Integer.parseInt(o2[1])+
                    Integer.parseInt(o1[1])*Integer.parseInt(o2[0]))
                    +"/"+String.valueOf(Integer.parseInt(o1[1])*Integer.parseInt(o2[1]));
        }

}


