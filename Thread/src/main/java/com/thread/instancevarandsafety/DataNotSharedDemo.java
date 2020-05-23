package com.thread.instancevarandsafety;

/**
 * @author liuc
 * @className DataNotSharedDemo
 * @description 多线程成员变量不共享
 * @date 2020/5/7 22:22
 * @since JDK 1.8
 */
public class DataNotSharedDemo extends Thread{
    int count = 10;
    @Override
    public void run() {
        while (count > 0){
            count --;
            System.out.println(Thread.currentThread().getName()+":"+count);
        }
    }
}
