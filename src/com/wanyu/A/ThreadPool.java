package com.wanyu.A;

import java.util.concurrent.ThreadPoolExecutor;

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
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor();
    }
}
