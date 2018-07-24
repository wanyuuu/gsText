package com.wanyu.Pattern.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by wanyu3 on 2018/7/12.
 */
public class Client {
    public static void main(String[] args) {
        //要代理的真实对象
        Subject realSubject = new RealSubject();
        InvocationHandler handler = new DynamicProxy(realSubject);
        /**
         * 第一个参数 加载代理对象
         * 第二个参数 提供真实的接口
         * 第三个参数 将代理对象关联到InvocationHandler对象上
         */
        //Proxy.newProxyInstance创建的代理对象是jvm运行时动态生成的一个对象(运行前代理未生成)
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),handler);
        subject.save("wanyu");
        System.out.println(realSubject.getClass().getName());//真实对象
        System.out.println(subject.getClass().getName());//代理对象
        //通过代理对象调用方法 跳转到由这个代理对象关联的handler中的invoke方法去执行
    }
}
