package com.thread.api;

/**
 * @className InterruptThreadInSleepDemo2
 * @description
 * @author liuc
 * @date 2020/5/22 23:08
 * @since JDK 1.8
 */
public class InterruptThreadInSleepDemo2 {
  public static void main(String[] args) {
    InterruptThreadInSleep2 itis = new InterruptThreadInSleep2();
    Thread thread = new Thread(itis);
    thread.start();
    thread.interrupt();
  }

  public static class InterruptThreadInSleep2 implements Runnable {
    @Override
    public void run() {
      try {
        for (int i = 0; i < 100000; i++) {
          System.out.println("i=" + (i + 1));
        }
        Thread.sleep(200000);
        System.out.println("run end!");
      } catch (InterruptedException e) {
        System.out.println("先停止，再遇到了sleep!进入catch！" + Thread.currentThread().isInterrupted());
        e.printStackTrace();
      }
    }
  }
}
