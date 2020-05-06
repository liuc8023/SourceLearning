package com.thread.implementation;

/**
 * @author liuc
 * @className ThreadImplRunnableDemo
 * @description 实现Runnable接口的方式实现多线程功能实例
 * @date 2020/4/30 14:03
 * @since JDK 1.8
 */
public class ThreadImplRunnableDemo implements Runnable{

    @Override
    public void run() {
        /*
         * 覆写run()方法，定义该线程需要执行的代码
         */
        for (int i = 0; i < 1000; i++) {
            /*
             * Thread.currentThread().getName() 获取当前线程的名称，
             * 其中main()方法的线程名是main
             */
            System.out.println(Thread.currentThread().getName()+":" +i);
        }
    }
}
