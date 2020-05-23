package com.thread.api;

/**
 * @className ThreadInterruptByFlagDemo
 * @description 通过置标记为相反的布尔值，来终止线程
 * @author liuc
 * @date 2020/5/23 17:20
 * @since JDK 1.8
 */
public class ThreadInterruptByFlagDemo {
  public static void main(String[] args) {
    try {
      ThreadInterruptByFlag tibf = new ThreadInterruptByFlag();
      Thread thread = new Thread(tibf);
      thread.start();
      Thread.sleep(1000);
      System.out.println(System.currentTimeMillis());
      tibf.cancel();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static class ThreadInterruptByFlag implements Runnable {
    private boolean flag = false;

    public void cancel() {
      this.flag = true;
    }

    @Override
    public void run() {
      while (true) {
        if (flag) {
          System.out.println("interrupt!");
          break;
        }
        try {
          System.out.println("t1 sleep");
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        Thread.yield();
      }
      System.out.println(System.currentTimeMillis());
    }
  }
}
