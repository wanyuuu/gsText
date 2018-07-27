package com.wanyu.A;

/**
 * Created by wanyu3 on 2018/7/27.
 */
public class volatileTest {
    private volatile int i = 0;
    public void setI(){
        i++;
    }
    public int getI(){
        return i;
    }

}
