package com.thread.api;

/**
 * @author liuc
 * @className SleepDemo
 * @description 让当前『正在执行的线程』暂停执行指定的毫秒数
 * @date 2020/5/11 9:10
 * @since JDK 1.8
 */
public class SleepDemo {
  public static void main(String[] args) {
    Sleep s = new Sleep();
    Thread t = new Thread(s);
    System.out.println("开始于" + System.currentTimeMillis());
    t.start();
    t.interrupt();
    System.out.println("结束于" + System.currentTimeMillis());
  }
}

class Sleep implements Runnable {
  @Override
  public void run() {
    try {
      System.out.println("线程开始于" + System.currentTimeMillis());
      Thread.sleep(2000);
      System.out.println("线程结束于" + System.currentTimeMillis());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
