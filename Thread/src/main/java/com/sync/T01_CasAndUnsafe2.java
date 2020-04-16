package com.sync;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
* 
* @className T01_CasAndUnsafe
* @author liuc
* @date 2020-04-05 15:18
* @since JDK 1.8
**/
public class T01_CasAndUnsafe2 {
    private static volatile int m = 0;

    public static void main(String[] args) throws Exception{
        Thread[] threads = new Thread[100];
        final CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()-> {
                for (int j = 0; j < 10000; j++) {
                    m++;
                }
                latch.countDown();
            });
        }
        Arrays.stream(threads).forEach((t)-> t.start());
        latch.await();
        System.out.println(m);
    }
}
