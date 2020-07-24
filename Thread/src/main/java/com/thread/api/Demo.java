package com.thread.api;

import java.util.stream.IntStream;

/**
 * @author liuc
 * @className Demo
 * @description
 * @date 2020/7/11 23:41
 * @since JDK 1.8
 */
public class Demo {
    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执⾏的线程是：%s，优先级：%d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }
    }
    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }
}
