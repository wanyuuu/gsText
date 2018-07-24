package com.wanyu.Pattern.Observer;

/**
 * Created by wanyu3 on 2018/4/27.
 */
public interface AbstractTeacher {
    public void addObservers(AbstractObserver observer);
    public void deleteObservers(AbstractObserver observer);
    public void NotifyAll(String msg);
}
