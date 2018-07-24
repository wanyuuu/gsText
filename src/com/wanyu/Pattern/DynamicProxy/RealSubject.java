package com.wanyu.Pattern.DynamicProxy;

/**
 * Created by wanyu3 on 2018/4/27.
 */
public class RealSubject implements Subject {
    @Override
    public void save(String name) {
        System.out.println(name+"正在测试");
    }
}
