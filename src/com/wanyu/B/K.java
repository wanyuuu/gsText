package com.wanyu.B;

import org.junit.Test;

/**
 * Created by wanyu3 on 2018/7/13.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class K {
    @Test
    public void test(){
        System.out.println(NumberOf1(-8));
    }
    public int NumberOf1(int n) {
       String str = Integer.toBinaryString(n);
        int sum = 0;
       for(int i = 0;i<str.length();i++){
           if(str.charAt(i) == '1'){
               sum++;
           }
       }
        return sum;
    }
}
