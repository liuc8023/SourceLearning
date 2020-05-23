package com.thread.api;

/**
 * @className InterruptedThreadDemo
 * @description 测试当前线程是否已经中断
 * @author liuc
 * @date 2020/5/21 14:42
 * @since JDK 1.8
 */
public class InterruptedThreadDemo {
  public static void main(String[] args) {
    try {
      InterruptedThread it = new InterruptedThread();
      Thread thread = new Thread(it);
      thread.start();
      Thread.sleep(1000);
      thread.interrupt();
      System.out.println("是否停止1=" + Thread.interrupted());
      System.out.println("是否停止2=" + Thread.interrupted());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class InterruptedThread implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      System.out.println("i = " + (i + 1));
    }
  }
}
