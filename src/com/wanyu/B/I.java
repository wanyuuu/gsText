package com.wanyu.B;

import org.junit.Test;

/**
 * Created by wanyu3 on 2018/7/13.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 *求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class I {
    @Test
    public void test(){
        System.out.println(JumpFloorII(5));
    }
    public int JumpFloorII(int target) {
        if(target == 1){
            return 1;
        }
        int total = 1;
        for(int i = 1 ;i<target;i++){
            total = total*2;
        }
        return total;
    }
}
