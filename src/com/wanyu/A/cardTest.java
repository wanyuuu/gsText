package com.wanyu.A;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wanyu3 on 2018/7/25.
 */
public class cardTest {
   static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    public static void main(String[] args) {
        final Card card = new Card("22",0);
        final cardTest userTest = new cardTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                    int money = 300;
                    rwlock.writeLock().lock();
                    userTest.saveMoney(card,money);
                    System.out.println("用户"+Thread.currentThread().getName()+"存了"+money);
                    rwlock.writeLock().unlock();
                    rwlock.readLock().lock();
                    System.out.println("卡里还剩"+card.getMoney());
                    rwlock.readLock().unlock();

            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    int money = 200;
                    rwlock.writeLock().lock();
                System.out.println("用户"+Thread.currentThread().getName()+"要取"+money);
                    if(!userTest.delMoney(card,money)){
                        rwlock.writeLock().unlock();
                        System.out.println("余额不足，还剩"+card.getMoney());
                        return;
                    };
                    rwlock.writeLock().unlock();
                    rwlock.readLock().lock();
                    System.out.println("卡里还剩"+card.getMoney());
                    rwlock.readLock().unlock();
            }
        },"t2");
        t1.start();
        t2.start();
    }
    public void saveMoney(Card card,int money){
        int oldMoney = card.getMoney();
        card.setMoney(oldMoney+money);
    }
    public boolean delMoney(Card card,int money){
        int oldMoney = card.getMoney();
        if(oldMoney-money<0){
            return false;
        }else {
            card.setMoney(oldMoney-money);
            return true;
        }
    }
}
