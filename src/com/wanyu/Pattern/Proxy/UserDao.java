package com.wanyu.Pattern.Proxy;

/**
 * Created by wanyu3 on 2018/4/27.
 */
public class UserDao implements IUserDao {//目标对象
    @Override
    public void save() {
        System.out.println("已经保存数据");
    }

    @Override
    public void delete() {
        System.out.println("已经删除数据");
    }
}
