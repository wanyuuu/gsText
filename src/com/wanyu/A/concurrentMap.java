package com.wanyu.A;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by wanyu3 on 2018/7/3.
 */
public class concurrentMap {
    public static void main(String[] args) {
        //默认大小为16 装载因子0.75 两倍扩容
        HashMap hashMap = new HashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

       /*
        synchronized  key value 不允许为null 安全的 性能较差
        底层也是Entry数组 初始容量11 装载因子0.75  oldLength*2 + 1 扩容
        实现了Map Dictionary接口
        */
        Hashtable hashtable = new Hashtable();

        /*
        底层由Hashmap实现 初始容量16 装载因子0.75  不允许重复 可以添加重复元素 但只存在一个
        添加object到hashMap的key上 所以原来的元素不会被改变
        实现了Set接口 速度较慢
         */
        HashSet hashSet = new HashSet();
//        hashtable.put(null,"nnn");
        hashMap.put(null,null);
        hashSet.add("1");
        System.out.println(hashSet.add("1"));//返回false

        //基于动态数组 非线程安全 查询速度快 增加删除慢（因为需要数组复制） 需要扩容
        //初始容量10 1.5倍扩容 如何扩容 增加 删除
        // System.arrayCopy Arrays.copyOf 实现List接口
        List list = new ArrayList();
        list.add(1);
        list.add(null);

        //基于双向链表实现的线程非安全的集合 链表结构 不能随机访问 查询速度慢 可从头插 从尾插 插入速度快
        //查询时 类似二分 判断离头结点近还是尾节点近 然后便利寻找
        //实现了 List、Deque 接口
        LinkedList linkedList = new LinkedList();

        //实现了List接口 底层和arrayList类似 线程安全的 几乎所有方法都被synchronized修饰
        //当一个线程获得Vector对象的锁 其他线程必须等待其释放才能操作 所以性能较差
        //扩容 如果增长因子>0 则扩容增长因子的大小 <0 则扩容原来长度一倍
        Vector vector = new Vector();

        //当向容器添加元素的时候，不是直接添加，而是先将当前容器copy一份，在新容器里操作元素
        //然后将原容器的引用指向新容器，读写分离的思想，读写不同的容器。
        //适合高并发的场景（读多写少），写的操作多频繁复制容器影响性能。
        //在锁竞争的情况下有更高的性能。
        //ReentranLock锁，在add中加锁，add完成后解锁。
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(null);
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);
        copyOnWriteArrayList.remove(1);
        Iterator it = copyOnWriteArrayList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //无界线程安全队列 非阻塞 使用循环CAS
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

        //基于数组的阻塞队列实现 有界队列
        BlockingQueue blockingArrayQueue = new ArrayBlockingQueue(5);

        //基于链表的阻塞队列 内部采用读写分离两个锁 实现生产者消费者完全并行运行 是一个无界队列
        BlockingQueue blockingLinkQueue = new LinkedBlockingQueue<>();

    }
    @Test
    public void test(){
        //重写equals hashCode
        //equals 先比较两个对象的地址是否相等 如果地址相等 则相等
        //若地址不相等 比较长度是否相等 若相等 则分别用字符数组的形式 比较每个字符是否相等 若都相等 则返回true
        //hashCode  hash = hash * 31 + char[i] i++
        String s= "ss";
        System.out.println(s.equals("ss"));
        System.out.println(5+'A');
//        int a = Integer.parseInt(s);
        //数字的ascii都比字母小
        System.out.println('s'>'0');
        int arr[] = {1,2,3,4,5};
        int arrb[] = Arrays.copyOf(arr,10);//把元素copy进来 并扩展长度
        System.out.print(arrb.length);
    }
}
