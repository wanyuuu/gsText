package com.wanyu.Pattern.Observer;

/**
 * Created by wanyu3 on 2018/4/27.
 */
public class Test {
    public static void main(String[] args) {
        Observer observer1=new Observer("小明");
        Observer2 observer2=new Observer2("小马");
        Teacher teacher=new Teacher();
        teacher.addObservers(observer1);
        teacher.addObservers(observer2);
        teacher.NotifyAll("出成绩了");
        teacher.deleteObservers(observer1); //小明取消了订阅
        teacher.NotifyAll("今天放假");//只有小马接收到了新发布的信息

    }
}
