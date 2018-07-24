package com.wanyu.Pattern.Observer;

/**
 * Created by wanyu3 on 2018/4/27.
 */
public class Observer2 implements AbstractObserver {
    private String name;
    public Observer2(String name){
        this.name=name;
    }
    @Override
    public void UpdateMsg(String msg) {
        if("出成绩了".equals(msg)){
            System.out.println(this.name+"很悲伤");
        }else if("今天放假".equals(msg)){
            System.out.println(this.name+"去上网");
        }
    }
}
