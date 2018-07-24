package com.wanyu.A;

import java.util.Objects;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wanyu3 on 2018/4/26.
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        final Queue2 queue2=new Queue2();
        for(int i=0;i<3;i++){
            new Thread(){
                @Override
                public void run() {

                        queue2.put(new Random().nextInt(10000));

                }
            }.start();
        }
        for(int i=0;i<3;i++){
            new Thread(){
                @Override
                public void run() {

                    queue2.get();

                }
            }.start();
        }
    }
}
class Queue2{
    private Object data=null;
    private ReentrantReadWriteLock rw1=new ReentrantReadWriteLock();
    public void get(){
        rw1.readLock().lock();//读锁 其他线程只能读不能写
        System.out.println(Thread.currentThread().getName()+"准备读取数据");
        try {
            Thread.sleep((long) Math.random()*2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println(Thread.currentThread().getName()+"已经读取数据"+data);
            rw1.readLock().unlock();//释放读锁

    }
    public void put(Object data){
        rw1.writeLock().lock();//其它线程不能读不能写
        System.out.println(Thread.currentThread().getName()+"准备写入数据");
        try {
            Thread.sleep((long) Math.random()*2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            this.data=data;
            System.out.println(Thread.currentThread().getName()+"已经写入数据"+data);
           rw1.writeLock().unlock();

    }

}
