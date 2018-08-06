package com.wanyu.Test;

/**
 * Created by wanyu3 on 2018/8/3.
 */
public class Father {

    static {
        System.out.println("Father init");
    }
    public static int value = 123;
}
class Son extends Father{
    static {
        System.out.println("Son init");
    }
    public static final String HELLO = "hello";
    public static int value = 345;
}
