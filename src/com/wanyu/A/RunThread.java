package com.wanyu.A;

/**
 * Created by wanyu3 on 2018/7/3.
 */
public class RunThread extends Thread {
    private volatile boolean isRunning = true;
    public boolean isRunning(){
        return isRunning;
    }
    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
    @Override
    public void run() {
        System.out.println("线程进入run方法");
        while(isRunning == true){
            System.out.println("线程执行完成了");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

            RunThread thread = new RunThread();
            thread.start();
            thread.setRunning(false);

    }
}
