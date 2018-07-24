package com.wanyu.B;

import org.junit.Test;

/**
 * Created by wanyu3 on 2018/7/13.
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 斐波纳列数列
 */
public class J {
    @Test
    public void test(){
        System.out.println(RectCover(0));
    }
    public int RectCover(int target) {
        int Fi[] = new int[target+2];
        Fi[0] = 1;
        Fi[1] = 2;
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return Fi[0];
        }
        if(target == 2){
            return Fi[1];
        }
        for(int i = 2;i<target;i++){
            Fi[i] = Fi[i-1]+Fi[i-2];
        }
        return Fi[target-1];
    }
}
