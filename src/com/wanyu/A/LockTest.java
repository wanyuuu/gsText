package com.wanyu.A;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wanyu3 on 2018/5/24.
 */
public class LockTest {
    private Lock lock= new ReentrantLock();
    public void intoThread(Thread thread){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"获得了锁");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();//只有释放锁 其他线程才能使用该方法
            System.out.println(Thread.currentThread().getName()+"释放了锁");
        }
    }
    public void intoThread2(Thread thread){
        if(lock.tryLock()){//如果锁没被占用则返回true 若被占用返回false
            try{
                System.out.println(Thread.currentThread().getName()+"获取了锁");
                lock.lock();
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"释放了锁");
                lock.unlock();
            }
        }else {
            System.out.println("锁已被占用，"+Thread.currentThread().getName()+"放弃获取");
        }
    }

    public static void main(String[] args) {
        final LockTest lockTest=new LockTest();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.intoThread2(Thread.currentThread());
            }
        },"t1");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.intoThread2(Thread.currentThread());
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
