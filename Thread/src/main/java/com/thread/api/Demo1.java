package com.thread.api;

/**
 * @author liuc
 * @className Demo1
 * @description
 * @date 2020/7/12 16:44
 * @since JDK 1.8
 */
public class Demo1{
    public static void main(String[] args) {
        MyThread1 th = new MyThread1();
        Thread t1 = new Thread(th);
        //给MyThread1设置为最高等级
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
    }

    public static class MyThread1 implements Runnable{
        @Override
        public void run() {
            System.out.println("MyThread1 run priority="+Thread.currentThread().getPriority());
            MyThread2 td = new MyThread2();
            Thread t = new Thread(td);
            t.start();
        }
    }

    public static class MyThread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("MyThread2 run priority="+Thread.currentThread().getPriority());
        }
    }
}
