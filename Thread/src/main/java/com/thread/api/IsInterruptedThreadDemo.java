package com.thread.api;

/**
 * @className IsInterruptedThreadDemo
 * @description 测试线程是否已经中断
 * @author liuc
 * @date 2020/5/21 16:10
 * @since JDK 1.8
 */
public class IsInterruptedThreadDemo {
  public static void main(String[] args) {
    IsInterruptedThread it = new IsInterruptedThread();
    Thread thread = new Thread(it);
    thread.start();
    // 在当前线程中打了一个停止的标记
    thread.interrupt();
    // 测试线程是否已经中断
    System.out.println(thread.getName() + ",是否停止1=" + thread.isInterrupted());
    System.out.println(thread.getName() + ",是否停止2=" + thread.isInterrupted());
  }

  public static class IsInterruptedThread implements Runnable {
    @Override
    public void run() {
      for (int i = 0; i < 3; i++) {
        System.out.println(Thread.currentThread().getName() + ",i = " + (i + 1));
      }
    }
  }
}
