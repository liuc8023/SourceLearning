package com.thread.api;

/**
 * @author liuc
 * @className TestCurrentThreadDemo
 * @description 获取CPU正在执行那个线程调用的详细信息测试类
 * @date 2020/5/8 21:01
 * @since JDK 1.8
 */
public class TestCurrentThreadDemo {
  public static void main(String[] args) {
    CurrentThreadDemo c = new CurrentThreadDemo();
    Thread t = new Thread(c);
    // 给线程设置名称
    t.setName("my name is Hello Thread");
    t.start();
  }
}
