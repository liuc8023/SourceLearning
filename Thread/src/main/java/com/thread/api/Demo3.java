package com.thread.api;

import java.util.Random;

/**
 * @author liuc
 * @className Demo3
 * @description
 * @date 2020/7/12 17:38
 * @since JDK 1.8
 */
public class Demo3 {
    public static void main(String[] args) {
        //在启动之前分别设置两个线程的优先级
        Demo2.test01 test01 = new Demo2.test01();
        test01.setPriority(6);
        test01.start();
        Demo2.test02 test02 = new Demo2.test02();
        test02.setPriority(5);
        test02.start();
    }

    public static class test01 extends Thread {
        @Override
        public void run() {
            super.run();
            long beginTime = System.currentTimeMillis();
            long add = 0;
            for (int i = 0; i < 5000000; i++) {
                i++;
                Random random = new Random();
                random.nextInt();
                add = add + 1;
            }
            long endTime = System.currentTimeMillis();
            System.out.println(System.currentTimeMillis()+",test01运行时间为：" + (endTime - beginTime) + "毫秒！");
        }
    }

    public static class test02 extends Thread {
        @Override
        public void run() {
            super.run();
            long beginTime = System.currentTimeMillis();
            long add = 0;
            for (int i = 0; i < 5000000; i++) {
                i++;
                Random random = new Random();
                random.nextInt();
                add = add + 1;
            }
            long endTime = System.currentTimeMillis();
            System.out.println(System.currentTimeMillis()+",test02运行时间为：" + (endTime - beginTime) + "毫秒！");
        }
    }
}
