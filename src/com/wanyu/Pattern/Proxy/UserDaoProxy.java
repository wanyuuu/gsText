package com.wanyu.Pattern.Proxy;

/**
 * Created by wanyu3 on 2018/4/27.
 */
public class UserDaoProxy implements IUserDao {
    private IUserDao target;
    public UserDaoProxy(IUserDao target){
        this.target=target;
    }
    @Override
    public void save() {
        System.out.println("开始事务......");
        target.save();
        System.out.println("事务已提交......");
    }

    @Override
    public void delete() {
        System.out.println("开始事务");
        target.delete();
        System.out.println("事务已提交");
    }
}
