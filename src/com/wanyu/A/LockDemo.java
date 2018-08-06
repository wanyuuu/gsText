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
        同步队列采用的是双向链表的结构，方便进行节点增删操作。Node节点是对每一个获取锁（访问同步代码）的
        线程的封装。当前线程获取锁失败时，AQS会将该线程以及相关信息包装成一个节点并加入同步队列，同时会阻塞当前
        线程，当同步状态释放时，会将头结点head中的线程唤醒，让其尝试获取同步状态。
         */
        /*
        ReentrantLock内部存在3个实现类 分别是Sync、NonfairSync、FairSync，其中Sync继承AQS实现了解锁tryRelease
        方法，而NonfairSync、FairSync则继承自Sync，实现了获取锁的tryAcquire方法。
         */
        /*
        NonfairSync 1、加锁  执行CAS操作，尝试把state的状态从0到1，返回true则获取锁成功，可操作临界资源；若返回false则表示已有线程持有锁，
        获取失败。（CAS操作保证了操作state的原子性） 2、获取失败执行acquire再次尝试获取锁（判断state是否为0，为0执行CAS操作），是则执行CAS操作。
        如果当前线程已获得锁，属于重入锁，再次获取锁后status+1。
        tryAcquire如果返回true，说明当前线程已经获得锁，3、若返回false，则会执行addWaiter（Node.EXCLUSIVE）进行入队操作。
        addWaiter实现：4、把请求锁失败的线程封装成Node结点，如果是第一个结点或CAS操作失败执行enq操作（创建并设置head）。
        若非第一个结点则执行CAS操作，尝试在尾部快速添加。
        enq方法采用一个死循环进行CAS操作，解决多线程并发问题。做了两件事：1、初始化同步队列创建新结点 2、将结点插入到队尾
        5、添加到同步队列后，结点就会进入一个自旋过程，即每个节点都在等待条件满足获取同步状态，然后从同步队列退出并结束自旋。
        自旋是在acquireQueued中进行的：
            获取前驱节点，当为头结点时才尝试获取同步状态，获取同步状态后，将当前节点设置为head。
        符合FIFO规则。其次head是当前获取同步状态的节点，只有当head释放同步状态（释放锁）唤醒后继节点，后继节点才可能获取到同步状态，
        因此后继节点在其前继节点为head时，才尝试获取同步状态，其他时刻将被挂起。
            如果前驱节点不是head，那么判断是否将线程挂起 。获取当前节点的等待状态：

        可中断的获取方式：即调用ReentrantLock类的lockInterruptibly()或者tryLock()方法，最终它们都间接调用到doAcquireInterruptibly()。
        直接抛异常 中断线程的同步状态请求 从同步队列中移除
        */
        /*
            unlock解锁：getState、state-1后若=0，则说明已释放锁，释放同步状态后会唤醒后继节点的线程。
            公平锁加锁和非公平锁不同点：在CAS尝试设置state值前，会判断同步队列是否存在节点，如果存在必须执行完同步队列中节点的线程，
        当前线程封装成节点进入同步队列等待。而非公平锁不管同步队列中是否存在线程节点，直接尝试获取同步状态。
            在绝大多数情况下，非公平锁才是理想的选择，效率上远胜公平锁。
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
