package com.wanyu.A;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wanyu3 on 2018/7/24.
 */
public class LockDemo {
    /*
        1、Synchronized是jvm层面的关键字，Lock是一个类
        2、Synchronized获取锁的线程执行完同步代码，释放锁；线程执行发生异常，释放锁。
           Lock在finally中释放锁，不然容易造成死锁。
        3、Synchronized 假设A获取锁，B线程等待；A线程阻塞，B一直等待。
        4、Synchronized 锁的状态不可以判断 Lock 锁的状态可以判断 tryLock()
        5、Synchronized 是可重入锁 不可中断锁（在获取锁的时候不能中断）非公平锁 悲观锁
           Lock 是可重入锁 可中断锁 公平/非公平锁 乐观锁
     */
    public static void main(String[] args) {
        /*
        AQS又称为队列同步器，内部通过int类型的state来控制同步状态，state=0时，说明没有任何线程占有共享
        资源的锁，当前线程可以获取到锁，并设置state为1。当state=1时，说明有线程正在使用共享变量，即锁被
        其他线程持有，当前线程必须加入同步队列等待。
        AQS内部通过内部类Node构成FIFO的同步队列来完成线程获取锁的排队工作，同时利用内部类ConditionObject
        构建等待队列，当Condition调用wait方法后，线程进入等待队列，当调用signal方法后，线程从等待队列移到
        同步队列进行锁竞争。
        同步队列采用的是双向链表的结构，方面进行节点增删操作。Node节点是对每一个获取锁（访问同步代码）的
        线程的封装。当前线程获取锁失败时，AQS会将该线程以及相关信息包装成一个节点并加入同步队列，同时会阻塞当前
        线程，当同步状态释放时，会将头结点head中的线程唤醒，让其尝试获取同步状态。
         */
        /*
        ReentrantLock内部存在3个实现类 分别是Sync、NonfairSync、FairSync，其中Sync继承AQS实现了解锁tryRelease
        方法，而NonfairSync、FairSync则继承自Sync，实现了获取锁的tryAcquire方法。
         */
        /*
        NonfairSync 加锁  执行CAS操作，尝试把state的状态从0到1，返回true则获取锁成功，可操作临界资源；若返回false则表示已有线程持有锁，
        获取失败。（CAS操作保证了操作state的原子性） 获取失败执行acquire再次尝试获取锁（判断state是否为0，为0执行CAS操作），
        */
        //默认非公平锁
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
