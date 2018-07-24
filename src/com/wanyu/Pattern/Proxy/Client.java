package com.wanyu.Pattern.Proxy;

/**
 * Created by wanyu3 on 2018/4/27.
 * 静态代理 在不修改目标对象功能的前提下 对目标功能进行扩展
 * 一旦接口增加方法 目标类与代理类都要维护
 * 程序运行前 代理类就已存在 就为静态代理
 */
public class Client {
    public static void main(String[] args) {
        //目标对象
        UserDao userDao=new UserDao();
        //把目标对象传给代理对象 建立代理关系
        UserDaoProxy dao=new UserDaoProxy(userDao);
        //调用的是代理对象的方法
        dao.delete();
    }
}
