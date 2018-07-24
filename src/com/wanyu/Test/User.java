package com.wanyu.Test;

/**
 * Created by wanyu3 on 2018/7/19.
 */
public class User {
    private String name ;
    private int id;

    public User(String name,int id){
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getId()==((User)obj).getId()&&this.getName()==((User)obj).getName();
    }
    //不重写hashCode的话 hashSet中添加了两个相同的元素（地址不同） 违反特性
    @Override
    public int hashCode() {
        return this.getId()*22+1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
