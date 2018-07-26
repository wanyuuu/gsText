package com.wanyu.A;

/**
 * Created by wanyu3 on 2018/7/25.
 * 保证T2在T1后执行，T3在T2后执行
 * 使用join 在t2中t1.join 表示当前线程需要在t1上等待
 */
public class joinTest {
    public static void main(String[] args) {
       final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<3;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        },"t1");
        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<3;i++){
                    try {
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        },"t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<3;i++){
                    try {
                        t2.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        },"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
