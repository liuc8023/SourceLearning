package com.thread.instancevarandsafety;

/**
 * @author liuc
 * @className TestDataNotSharedDemo
 * @description 多线程成员变量不共享测试类
 * @date 2020/5/7 22:25
 * @since JDK 1.8
 */
public class TestDataNotSharedDemo {
    public static void main(String[] args) {
        Thread t1 = new DataNotSharedDemo();
        Thread t2 = new DataNotSharedDemo();
        t1.start();
        t2.start();
    }
}
