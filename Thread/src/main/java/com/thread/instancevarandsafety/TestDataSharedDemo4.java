package com.thread.instancevarandsafety;

/**
 * @author liuc
 * @className TestDataSharedDemo4
 * @description i --和System.out.println()引发的线程安全问题测试类
 * @date 2020/5/8 17:14
 * @since JDK 1.8
 */
public class TestDataSharedDemo4 {
    public static void main(String[] args) {
        // 创建一个DataSharedDemo4对象，并将该对象分别加载到五个线程中并分别给线程命名
        DataSharedDemo4 myThread = new DataSharedDemo4();
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        Thread t3 = new Thread(myThread);
        Thread t4 = new Thread(myThread);
        Thread t5 = new Thread(myThread);
        // 启动五个线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
