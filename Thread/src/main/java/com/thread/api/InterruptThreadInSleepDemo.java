package com.thread.api;

/**
 * @className InterruptThreadInSleepDemo
 * @description 在沉睡中停止线程
 * @author liuc
 * @date 2020/5/22 16:37
 * @since JDK 1.8
 */
public class InterruptThreadInSleepDemo {
  public static void main(String[] args) {
    try {
      InterruptThreadInSleep itis = new InterruptThreadInSleep();
      Thread thread = new Thread(itis);
      thread.start();
      Thread.sleep(200);
      thread.interrupt();
    } catch (InterruptedException e) {
      System.out.println("main catch");
      e.printStackTrace();
    }
    System.out.println("end!");
  }

  public static class InterruptThreadInSleep implements Runnable {
    @Override
    public void run() {
      try {
        System.out.println("run begin...");
        Thread.sleep(200000);
        System.out.println("run end!");
      } catch (InterruptedException e) {
        System.out.println("在沉睡中被停止！进入catch!" + Thread.currentThread().isInterrupted());
        e.printStackTrace();
      }
    }
  }
}
