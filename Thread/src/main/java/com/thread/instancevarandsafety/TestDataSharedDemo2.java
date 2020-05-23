package com.thread.instancevarandsafety;

/**
 * @author liuc
 * @className TestDataSharedDemo2
 * @description 多线程成员变量共享测试类
 * @date 2020/5/8 15:43
 * @since JDK 1.8
 */
public class TestDataSharedDemo2 {
    public static void main(String[] args) {
        DataSharedDemo2 dataSharedDemo2 = new DataSharedDemo2();
        Thread t1 = new Thread(dataSharedDemo2);
        Thread t2 = new Thread(dataSharedDemo2);
        Thread t3 = new Thread(dataSharedDemo2);
        Thread t4 = new Thread(dataSharedDemo2);
        Thread t5 = new Thread(dataSharedDemo2);
        Thread t6 = new Thread(dataSharedDemo2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
