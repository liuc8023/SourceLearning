package com.demo.queue;
/**
* 单向队列测试类
* @className TestArrayQueue
* @author liuc
* @date 2020-03-19 22:10
* @since JDK 1.8
**/
public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue sqQueue = new ArrayQueue(10);
        sqQueue.push("I");
        sqQueue.push("Love");
        sqQueue.push("You");
        sqQueue.push("!");
        sqQueue.display();
        System.out.println("队列的长度为：" + "\n" + sqQueue.size());
        System.out.println("判断队列是否为空：" + "\n" + sqQueue.isEmpty());
        System.out.println("判断队列是否已满：" + "\n" + sqQueue.isFull());
        System.out.println("取队首元素：" + "\n" + sqQueue.front());
        System.out.println("删除队首元素：" + "\n" + sqQueue.pop());
        System.out.println("队列的长度为：" + "\n" + sqQueue.size());
        sqQueue.display();
        System.out.println("清空对列：");
        sqQueue.clear();
        sqQueue.display();
        System.out.println("队列已清空！！");
    }
}
