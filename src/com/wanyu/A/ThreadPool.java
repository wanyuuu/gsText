package com.wanyu.A;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wanyu3 on 2018/8/6.
 */
public class ThreadPool {
    public static void main(String[] args) {
        /*
            corePoolSize 核心线程数量 核心池的大小
            maximumPoolSize 最大线程数量 线程池最大线程数
            keepAliveTime 线程没有任务执行时最多保持多久时间会终止
            TimeUnit unit 存活时间的单位
            BlockingQueue workQueue 保存待执行任务的队列
            ThreadFactory threadFactory 创建新线程使用的工厂
            handler 当任务无法执行时的处理器
         */
        /*
            新任务到线程池的流程
            1、首先判断核心线程池是否已满？没满，创建新线程执行任务；满了或者创建线程失败，加入到队列中。
            2、判断队列是否已满？没满，将任务存到工作队列中；满了，加入到线程池中。
            3、判断线程池是否已满？没满，创建一个新的工作线程执行任务；满了，交给饱和策略处理这个任务。
         */
        Runnable r1 = new Thread(new Tiger());
        Runnable r2 = new Thread(new Lion());
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>();
        blockingQueue.add(r1);
        blockingQueue.add(r2);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5,20,1000, TimeUnit.MINUTES,blockingQueue);
        /*
            根据源码如何实现：
            线程为null，抛异常。
         */
        threadPool.execute(r1);
        threadPool.execute(r2);
    }
}
class Tiger implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i < 3;i++){
            System.out.println(Thread.currentThread().getName()+":tiger");
        }
    }
}
class Lion implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 3;i++){
            System.out.println(Thread.currentThread().getName()+":lion");
        }
    }
}
