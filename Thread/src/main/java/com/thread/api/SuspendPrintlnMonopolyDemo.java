package com.thread.api;

/**
 * @author liuc
 * @className SuspendPrintlnMonopolyDemo
 * @description suspend下println方法独占问题
 * @date 2020/7/9 16:39
 * @since JDK 1.8
 */
public class SuspendPrintlnMonopolyDemo {
    public static void main(String[] args) {
        try {
            SuspendPrintlnMonopoly spm = new SuspendPrintlnMonopoly();
            Thread thread = new Thread(spm);
            thread.start();
            Thread.sleep(1000);
            thread.suspend();
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class SuspendPrintlnMonopoly implements Runnable {
        private long i = 0;
        @Override
        public void run() {
            while (true) {
                i++;
                System.out.println(i);
            }
        }
    }
}
