package com.wanyu.A;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wanyu3 on 2018/7/24.
 */
public class LockDemo {
    public static void main(String[] args) {
        //重入锁 支持线程重入的互斥锁
        //ReentrantLock实现了lock ReentrantLock中的Sync类实现了AQS-AbstractQueuedSynchronizer
        //FairSync和NonfairSync 是Sync的子类
        //tryAcquire方法 state表示重入次数 为0表示当前锁没有被线程持有 则让当前线程持有
        //如果锁被持有 则state+1 重入次数最大2^31 -1
        //公平锁中，tryAcquire方法的hasQueuedPredecessors判断同步队列中是否有更早等待锁的线程 这一句实现了公平锁
        //如果有 则返回false，让当前线程返回同步队列中进行等待
        //tryLock() 失败不阻塞而是直接返回false 在获取锁时使用非公平锁 随时可以插队 若使用公平锁将会一直等待 获取不到锁
        Lock reentranLock = new ReentrantLock();

        //也是基于AQS实现的 自定义同步器需要在同步状态上维护多个读线程和一个写线程
        //如果在一个整形变量上维护多种状态，就一定要按位切割使用这个变量，读写锁将变量切分成了
        //两个部分 高16位表示读 低16位表示写
        //实现了ReadWriteLock 允许多个线程同时访问 允许同时读 但不能同时读写和同时写
        //支持公平锁和非公平锁的方式 支持可重入
        //允许从写入锁降级为读取锁
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock().lock();
    }
}
