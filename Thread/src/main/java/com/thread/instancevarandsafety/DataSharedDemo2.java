package com.thread.instancevarandsafety;

/**
 * @author liuc
 * @className DataSharedDemo2
 * @description 多线程成员变量共享
 * @date 2020/5/8 15:42
 * @since JDK 1.8
 */
public class DataSharedDemo2 implements Runnable{
    int count = 4;
    @Override
    public void run() {
        //此处不要用循环，否则将是一个线程循环完，其他线程没有机会运行
        count --;
        System.out.println(Thread.currentThread().getName()+":"+count);
    }
}
