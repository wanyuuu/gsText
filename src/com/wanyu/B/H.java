package com.wanyu.B;

import org.junit.Test;

/**
 * Created by wanyu3 on 2018/7/12.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 斐波那契数列 可用迭代做
 */
public class H {
    @Test
    public void test(){
        System.out.println(JumpFloor(4));
    }
    public int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else {
            return JumpFloor(target-1)+ JumpFloor(target-2);
        }
    }
}
