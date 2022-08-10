package com.leetcode;

/**
 * @description: 593. 有效的正方形
 * @author: sixiermu
 * @time: 2022/7/29 9:05
 */
public class PanDuanZhengFangXing {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int diagonal = Math.max(cal_DistanceOfSquare(p1,p2),cal_DistanceOfSquare(p1,p3));
            diagonal = Math.max(diagonal,cal_DistanceOfSquare(p1,p4));
        if(diagonal==0)return false;

        //判断对角线
        if(cal_DistanceOfSquare(p1,p2) == cal_DistanceOfSquare(p3,p4) && cal_DistanceOfSquare(p1,p2)==diagonal){
            if((cal_DistanceOfSquare(p1,p3)==cal_DistanceOfSquare(p1,p4))&&
                (cal_DistanceOfSquare(p2,p3)==cal_DistanceOfSquare(p2,p4))&&
                 (cal_DistanceOfSquare(p1,p3)==cal_DistanceOfSquare(p2,p3))){
                return true;
            }
        }else if(cal_DistanceOfSquare(p1,p3) == cal_DistanceOfSquare(p2,p4) && cal_DistanceOfSquare(p1,p3)==diagonal){
            if((cal_DistanceOfSquare(p1,p2)==cal_DistanceOfSquare(p1,p4))&&
                    (cal_DistanceOfSquare(p3,p2)==cal_DistanceOfSquare(p3,p4))&&
                    (cal_DistanceOfSquare(p1,p2)==cal_DistanceOfSquare(p2,p3))){
                return true;
            }
        }else if(cal_DistanceOfSquare(p1,p4) == cal_DistanceOfSquare(p2,p3) && cal_DistanceOfSquare(p1,p4)==diagonal){
            if((cal_DistanceOfSquare(p1,p2)==cal_DistanceOfSquare(p1,p3))&&
                    (cal_DistanceOfSquare(p4,p2)==cal_DistanceOfSquare(p4,p3))&&
                    (cal_DistanceOfSquare(p1,p2)==cal_DistanceOfSquare(p4,p2))){
                return true;
            }
        }
        return false;
    }
    public int cal_DistanceOfSquare(int[] p1, int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }

}
