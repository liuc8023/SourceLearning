package com.thread.instancevarandsafety;

/**
 * @author liuc
 * @className TestDataSharedDemo3
 * @description 多线程成员变量共享测试类
 * @date 2020/5/8 15:25
 * @since JDK 1.8
 */
public class TestDataSharedDemo3 {
    public static void main(String[] args) {
        Thread a = new Thread(new DataSharedDemo3("A"));
        Thread b = new Thread(new DataSharedDemo3("B"));
        Thread c = new Thread(new DataSharedDemo3("C"));
        Thread d = new Thread(new DataSharedDemo3("D"));
        Thread e = new Thread(new DataSharedDemo3("E"));
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
