package com.thread.api;

/**
 * @className ThreadInterruptByExceptionDemo
 * @description 通过异常的方式中断线程
 * @author liuc
 * @date 2020/5/22 14:01
 * @since JDK 1.8
 */
public class ThreadInterruptByExceptionDemo {
  public static void main(String[] args) {
    try {
      ThreadInterruptByException tibe = new ThreadInterruptByException();
      Thread thread = new Thread(tibe);
      thread.start();
      Thread.sleep(1000);
      // 设置线程中断标记
      thread.interrupt();
    } catch (InterruptedException e) {
      System.out.println("main catch");
      e.printStackTrace();
    }
    System.out.println("end!");
  }

  public static class ThreadInterruptByException implements Runnable {
    @Override
    public void run() {
      try {
        for (int i = 0; i < 200000; i++) {
          // 判断线程是否已经中断
          while (Thread.currentThread().isInterrupted()) {
            System.out.println("已经是停止状态了！我要退出了！");
            // 此处可以用return；
            throw new InterruptedException();
          }
          System.out.println("i=" + (i + 1));
        }
        System.out.println("for之后代码标识线程未停止");
      } catch (InterruptedException e) {
        System.out.println("进入ThreadInterruptByException类run中的catch了！");
        e.printStackTrace();
      }
    }
  }
}
