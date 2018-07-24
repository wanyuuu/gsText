package com.wanyu.B;

import org.junit.Test;

/**
 * Created by wanyu3 on 2018/7/12.
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class G {
    @Test
    public void test(){
        System.out.println(Fibonacci(2));
    }
    public int Fibonacci(int n) {
        int Fi[] = new int[n+1];
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        Fi[0] = 0;
        Fi[1] = 1;
        for(int i = 2 ;i <= n;i++){
            Fi[i] = Fi[i-1] + Fi[i-2];
        }
        return Fi[n];
    }
}
