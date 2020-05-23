package com.thread.instancevarandsafety;

/**
 * @author liuc
 * @className TestDataSharedDemo1
 * @description 多线程成员变量共享测试类
 * @date 2020/5/8 15:25
 * @since JDK 1.8
 */
public class TestDataSharedDemo1 {
    public static void main(String[] args) {
        Thread a = new Thread(new DataSharedDemo1("A"));
        Thread b = new Thread(new DataSharedDemo1("B"));
        Thread c = new Thread(new DataSharedDemo1("C"));
        Thread d = new Thread(new DataSharedDemo1("D"));
        Thread e = new Thread(new DataSharedDemo1("E"));
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
