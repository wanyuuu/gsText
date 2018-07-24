package com.wanyu.Pattern.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wanyu3 on 2018/4/27.
 * 动态代理类
 */
public class DynamicProxy implements InvocationHandler {
    private Object object;
    //给要代理的真实对象赋初值
    public DynamicProxy(Object object){
        this.object = object;
    }

    /**
     *
     * @param proxy  代理对象
     * @param method  指代我们所要调用真实对象的某个方法的Method对象
     * @param args  调用真实对象某个方法时接收的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("测试开始");
        Object result=method.invoke(object,args);
        System.out.println("测试结束");
        System.out.println(proxy.getClass().getName());
        System.out.println(method.getName().getClass());
        return result;
    }
}
