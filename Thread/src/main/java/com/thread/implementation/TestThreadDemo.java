package com.thread.implementation;

/**
 * @author liuc
 * @className TestThreadDemo
 * @description 继承Thread方式实现多线程功能实例测试类
 * @date 2020/4/30 9:47
 * @since JDK 1.8
 */
public class TestThreadDemo {
    public static void main(String[] args) {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        ThreadDemo threadDemo1 = new ThreadDemo();
        ThreadDemo threadDemo2 = new ThreadDemo();
        /*
         * 调用start()方法启动线程
         */
        threadDemo2.start();
        threadDemo1.start();
        threadDemo1.run();
    }
}
