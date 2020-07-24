package com.thread.api;

/**
 * @author liuc
 * @className SuspendMonopolyDemo
 * @description suspend独占问题
 * @date 2020/7/9 15:17
 * @since JDK 1.8
 */
public class SuspendMonopolyDemo {
    public static void main(String[] args) {
        try {
            SuspendMonopoly sm = new SuspendMonopoly();
            Thread t1 = new Thread(){
                @Override
                public void run() {
                    super.run();
                    sm.printString();
                }
            };
            t1.setName("A");
            t1.start();
            Thread.sleep(3000);
            Thread t2 = new Thread(){
                @Override
                public void run() {
                    super.run();
                    sm.printString();
                }
            };
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class SuspendMonopoly {
        synchronized public void printString() {
            System.out.println("begin");
            if ("A".equals(Thread.currentThread().getName())) {
                System.out.println("A线程永远suspend了!");
                Thread.currentThread().suspend();
            }
            System.out.println("end");
        }
    }
}
