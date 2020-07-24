package com.thread.api;

import java.util.concurrent.TimeUnit;

/**
 * @author liuc
 * @className Test
 * @description
 * @date 2020/7/23 17:26
 * @since JDK 1.8
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        //设置一个钩子线程，在JVM退出时输出日志
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("The JVM exit success !!!")));
        //在主线程中new一个非守护线程
        Thread thread = new Thread(() ->{
            //模拟非守护线程不退出的情况
            while (true) {
               try {
                   TimeUnit.SECONDS.sleep(1);
                   System.out.println("I am running ...");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            }
        });
        //将该线程设置为守护线程，设置守护线程必须在线程启动前，不然会报错
        thread.setDaemon(true);
        //启动线程
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("The main thread ready to exit..");
    }
}
