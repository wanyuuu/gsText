package com.wanyu.A;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wanyu3 on 2018/4/26.
 */
public class CacheDemo {
    private  Map<String,Object> map=new HashMap<String,Object>();
    private  ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();
    @Test
    public void test(){
        final CacheDemo cache=new CacheDemo();
        for(int i=0;i<3;i++){
            new Thread(){
                @Override
                public void run() {
                    System.out.println(cache.get("hhhj"));
                }
            }.start();
        }
    }
    public Object get(String id){
        Object value=null;
        rwlock.readLock().lock(); //上读锁
        try {
            value = map.get(id);
            if (value == null) { //如果缓存中没有 则释放读锁，上写锁
                rwlock.readLock().unlock();
                rwlock.writeLock().lock();
            }try{
                if(value==null){
                    value="jd";
                }
            }finally {
                rwlock.writeLock().unlock();
            }
            rwlock.readLock().lock();
        }finally {
            rwlock.readLock().unlock();
        }
        return Thread.currentThread().getName()+value;
    }
}
