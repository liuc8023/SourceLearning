package com.thread.instancevarandsafety;

/**
 * @author liuc
 * @className DataSharedDemo4
 * @description i --和System.out.println()引发的线程安全问题
 * @date 2020/5/8 17:12
 * @since JDK 1.8
 */
public class DataSharedDemo4 extends Thread{
    int i = 100;
    @Override
    public void run() {
        while (i > 0) {
            //注意：i--改到println() 方法中直接打印。
            System.out.println("i=" + (i--) + " threadName=" + Thread.currentThread().getName());
        }
    }
}
