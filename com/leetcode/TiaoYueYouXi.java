package com.leetcode;

/**
 * @description: 45. 跳跃游戏 II 
 * @author: sixiermu
 * @time: 2022/8/10 16:09
 */
public class TiaoYueYouXi {
    public int jump(int[] nums) {
        int len = nums.length;

        int step = 0;
        int index = 0;
        if(len==1)return 0;
        for(int i=0;i<len;){
            int a = nums[i];
            //如果当前从位置再跳一次可达到
            if(i+a >= len-1){
                step++;
                break;
            }
            //找当前可达范围内 可达最远的位置
            int maxstep = 0;
            for(int j=i;j<= i + a;j++){
                if( j + nums[j] > maxstep){
                    maxstep = j + nums[j];
                    //标记该位置
                    index = j;
                }
            }
            i = index;
            ++step;
        }
        return step;
    }
}
