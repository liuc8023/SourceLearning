package com.thread.api;

/**
 * @className ThreadInterruptByStopDemo
 * @description 暴力停止，但不推荐
 * @author liuc
 * @date 2020/5/23 12:28
 * @since JDK 1.8
 */
public class ThreadInterruptByStopDemo {
  public static void main(String[] args) {
    try {
      ThreadInterruptByStop tibs = new ThreadInterruptByStop();
      Thread thread = new Thread(tibs);
      thread.start();
      Thread.sleep(8000);
      thread.stop();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static class ThreadInterruptByStop implements Runnable {
    private int i = 0;
    @Override
    public void run() {
      try {
        while (true) {
          i++;
          System.out.println("i=" + i);
          Thread.sleep(1000);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
