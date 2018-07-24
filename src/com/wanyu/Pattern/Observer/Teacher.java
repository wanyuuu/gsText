package com.wanyu.Pattern.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanyu3 on 2018/4/27.
 */
public class Teacher implements AbstractTeacher {
    private List<AbstractObserver> list=new ArrayList<AbstractObserver>();

    @Override
    public void addObservers(AbstractObserver observer) {
        list.add(observer);
    }

    @Override
    public void deleteObservers(AbstractObserver observer) {
        list.remove(observer);
    }

    @Override
    public void NotifyAll(String msg) {
        for (AbstractObserver o:list) {
            o.UpdateMsg(msg);
        }
    }
}
