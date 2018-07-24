package com.wanyu.A;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wanyu3 on 2018/5/29.
 */
public class Lock2Test {
    final static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (lock.tryLock()) { //被其他线程占用则返回false
                    lock.lock();       //锁后仍是true
                    System.out.println(Thread.currentThread().getName() + "获取了锁"+lock.tryLock());
                }
                try {
                    if (lock.tryLock()) {
                        for (int i = 0; i < 5; i++) {
                            System.out.println(Thread.currentThread().getName() +":"+i + "正在运行");
                            Thread.sleep(1000);
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "想要获取，但锁已被占用，无法获取");
                        return ;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if(lock.tryLock()) {
                        lock.unlock();
                        System.out.println("锁已被释放");
                    }
                    System.out.println(Thread.currentThread().getName()+lock.tryLock());
                }
            }
        }, "t1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (lock.tryLock()) {//仅在调用时锁为空闲状态才获取
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "获取了锁"+lock.tryLock());
                }
                try {
                    if (lock.tryLock()) {
                        for (int i = 0; i < 5; i++) {
                            System.out.println(Thread.currentThread().getName() +":"+i+ "正在运行");
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "想要获取，但锁已被占用，无法获取");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if(lock.tryLock()) {
                        lock.unlock();
                        System.out.println("锁已被释放");
                    }
                    System.out.println(Thread.currentThread().getName()+lock.tryLock());
                }
            }
        }, "t2").start();

    }
}
