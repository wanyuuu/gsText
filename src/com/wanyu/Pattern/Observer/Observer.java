package com.wanyu.Pattern.Observer;

/**
 * Created by wanyu3 on 2018/4/27.
 */
public class Observer implements AbstractObserver {
    private String name;
    public Observer(String name){
        this.name=name;
    }
    @Override
    public void UpdateMsg(String msg) {
       if("出成绩了".equals(msg)){
           System.out.println(this.name+"很难过");
       }else if("今天放假".equals(msg)){
           System.out.println(this.name+"去打篮球");
       }
    }
}
