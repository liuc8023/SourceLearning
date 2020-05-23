package com.thread.api;

/**
 * @author liuc
 * @className CurrentThreadDemo
 * @description 获取CPU正在执行那个线程调用的详细信息
 * @date 2020/5/8 20:59
 * @since JDK 1.8
 */
public class CurrentThreadDemo implements Runnable {
  @Override
  public void run() {
    System.out.println("当前执行的线程名称：" + Thread.currentThread().getName());
    System.out.println("获取当前线程的唯一标识：" + Thread.currentThread().getId());
  }
}
