package com.thread.implementation;

/**
 * @author liuc
 * @className TestThreadImplRunnableDemo
 * @description 实现Runnable接口的方式实现多线程功能实例测试类
 * @date 2020/4/30 14:04
 * @since JDK 1.8
 */
public class TestThreadImplRunnableDemo {
    public static void main(String[] args) {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        Runnable r = new ThreadImplRunnableDemo();
        Thread t = new Thread(r);
        Thread t2 = new Thread(r);
        t.start();
        t2.start();
    }
}
