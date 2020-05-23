package com.thread.api;

/**
 * @className ThreadInterruptByReturnDemo
 * @description 将方法interrupt()与return结合使用也能实现停止线程的效果
 * @author liuc
 * @date 2020/5/23 16:54
 * @since JDK 1.8
 */
public class ThreadInterruptByReturnDemo {
  public static void main(String[] args) {
    try {
      ThreadInterruptByReturn tibr = new ThreadInterruptByReturn();
      Thread thread = new Thread(tibr);
      thread.start();
      Thread.sleep(2000);
      thread.interrupt();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static class ThreadInterruptByReturn implements Runnable {
    @Override
    public void run() {
      while (true) {
        if (Thread.currentThread().isInterrupted()) {
          System.out.println("停止了！");
          return;
        }
        System.out.println("timer=" + System.currentTimeMillis());
      }
    }
  }
}
