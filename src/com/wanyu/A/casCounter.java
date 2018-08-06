package com.wanyu.A;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wanyu3 on 2018/7/26.
 */
public class casCounter {
    /*
    CAS操作 比较并交换 是解决多线程并行情况下使用锁造成性能损耗的一种机制 使用了乐观锁的思想
    CAS处理包括三个操作数 内存位置V、预期原值A和新值B。如果内存位置上的值与预期值相同，那么处理器会自动将
    该位置更新为新值，否则不做任何处理。java.util.concurrent.atomic 包下的类大多使用CAS实现。
     以自旋的方式不断去进行CAS操作 成功就返回结果 否则就一直重复下去
     当线程数量较多时 竞争强 循环时间长 应减少竞争
     CAS利用JNI（JNI Native Interface）来完成cpu指令的操作
     */
    /*
    CAS操作能解决原子操作 但仍存在三大问题
    1、ABA问题 CAS在操作值得时候需要检查值有没有变化 没有变化则更新 但如果一个值由 A 到 B 又到 A 则检查不出变化
    实际上已经发生变化 。解决思路使用版本号 在变量前面加上版本号 每次更新版本号+1
    2、循环时间长开销大。自旋CAS长时间不成功，会造成非常大的CPU开销。
    3、只能保证一个共享变量的原子操作。用锁。
     */
    /*
    对于资源竞争较少（线程冲突较轻）的情况，使用synchronized同步锁进行线程阻塞和唤醒切换以及用户内核间的
    切换操作额外浪费消耗cpu资源 ；而CAS操作基于硬件实现，不需要进入内核，不需要切换线程，操作自旋几率较少，
    因此可获得更高的性能。
    在jdk1.6以后，synchronized进行了优化。底层依靠Lock-Free的队列，先自旋后阻塞，竞争切换后继续竞争锁，稍微
    牺牲了公平性，但获得了高吞吐量。在线程较少的情况下，可获得和CAS类似的性能，线程多的情况下，性能远高于CAS。
            */
    //并发情况下 效率 会比synchronized 要高
    private static AtomicInteger count = new AtomicInteger(0);
    private int num = 0;

    public casCounter() {

    }

    public static int getCount() {
        return count.get();
    }

    public static void addCount() {
        count.getAndIncrement();
    }

    public int getNum() {
        return num;
    }

    public void addNum() {
        num++;
    }

    @Test
    public void test() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 5000; j++) {
                        addCount();
                    addNum();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<5000;i++){
                    addCount();
                    addNum();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
            System.out.println(getNum()); //可能出现不是10000
            System.out.println(getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
