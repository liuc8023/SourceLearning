package com.sync;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
*
* @className T02_CasAndUnsafe3
* @author liuc
* @date 2020-04-05 15:27
* @since JDK 1.8
**/
public class T02_CasAndUnsafe3 {
    private static AtomicInteger m = new AtomicInteger(0);

    public static void main(String[] args) throws Exception{
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        Object o = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()-> {
                for (int j = 0; j < 10000; j++) {
                    //incrementAndGet是CAS操作
                    m.incrementAndGet();
                }
                latch.countDown();
            });
        }
        Arrays.stream(threads).forEach((t)-> t.start());
        latch.await();
        System.out.println(m);
    }
}