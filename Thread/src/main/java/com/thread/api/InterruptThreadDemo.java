package com.thread.api;

/**
 * @className InterruptThreadDemo
 * @description 停止线程之interrupt
 * @author liuc
 * @date 2020/5/13 17:04
 * @since JDK 1.8
 */
public class InterruptThreadDemo {
  public static void main(String[] args) {
    try {
      InterruptThread it = new InterruptThread();
      Thread t = new Thread(it);
      t.start();
      Thread.sleep(2000);
      t.interrupt();
    } catch (InterruptedException e) {
      System.out.println("main catch");
      e.printStackTrace();
    }
  }
}

class InterruptThread implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 50000; i++) {
      System.out.println("i =" + (i + 1));
    }
  }
}
