package com.wanyu.A;

/**
 * Created by wanyu3 on 2018/7/3.
 * 当一个线程访问一个对象的同步代码块时，另一个线程仍可以访问该对象的非同步代码块
 */
public class Thread2 extends Thread {
    public static void main(String[] args) {
        final Thread2 thread = new Thread2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread.test1();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread.test2();
            }
        },"t2");
        t1.start();
        t2.start();
    }
    public void test1(){
        synchronized (this){
            int i = 3;
            while(i-->0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void test2(){
        synchronized (this){
            int i = 3;
        while(i-->0){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }
}
