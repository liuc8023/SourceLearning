package com.thread.api;

/**
 * @author liuc
 * @className IsAliveDemo
 * @description 判断当前线程是否处于活动状态
 * @date 2020/5/9 22:20
 * @since JDK 1.8
 */
public class IsAliveDemo {
  public static void main(String[] args) {
    IsAlive alive = new IsAlive();
    Thread t = new Thread(alive);
    System.out.println("准备开始启动线程：" + t.isAlive());
    // 启动线程
    t.start();
    System.out.println("启动线程后：" + t.isAlive());
  }
}

class IsAlive implements Runnable {
  @Override
  public void run() {
    System.out.println("run方法运行状态：" + Thread.currentThread().isAlive());
  }
}
