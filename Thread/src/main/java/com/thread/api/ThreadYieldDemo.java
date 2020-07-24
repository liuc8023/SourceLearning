package com.thread.api;

/**
 * @author liuc
 * @className ThreadYieldDemo
 * @description
 * @date 2020/7/10 10:12
 * @since JDK 1.8
 */
public class ThreadYieldDemo {
    public static void main(String[] args) {
        ThreadYield ty = new ThreadYield();
        Thread t1 = new Thread(ty);
        t1.setName("A");
        Thread t2 = new Thread(ty);
        t2.setName("B");
        t1.start();
        t2.start();
    }

    public static class ThreadYield implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 200; i++) {
                if ("A".equals(Thread.currentThread().getName()) && i ==100) {
                    System.out.println(Thread.currentThread().getName()+":"+i+".........yield");
                    //暂停线程
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
