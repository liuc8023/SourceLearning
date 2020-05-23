package com.thread.api;

/**
 * @className MainInterruptedThreadDemo
 * @description 测试使main线程产生中断效果
 * @author liuc
 * @date 2020/5/21 15:52
 * @since JDK 1.8
 */
public class MainInterruptedThreadDemo {
  public static void main(String[] args) {
    Thread.currentThread().interrupt();
    System.out.println("是否停止1=" + Thread.interrupted());
    System.out.println("是否停止2=" + Thread.interrupted());
    System.out.println("end!");
  }
}
