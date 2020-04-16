package com.demo.queue;
/**
* 
* @className TestLinkedQueue
* @author liuc
* @date 2020-03-20 15:31
* @since JDK 1.8
**/
public class TestLinkedQueue {

    public static void main(String[]args) throws Exception {
        LinkedQueue linkQueue = new LinkedQueue(10);
        System.out.println("队列是否为空："+linkQueue.isEmpty());
        System.out.println("连续入队-------------------------------");
        for(int i=0;i<5;i++){
            linkQueue.push((char)(97+i));
        }
        linkQueue.display();
        System.out.println("队列长度为："+linkQueue.size());
        System.out.println("队首元素为："+linkQueue.front());

        //出队
        System.out.println("连续出队-------------------------------");
        for(int i=0;i<4;i++){
            Object data=linkQueue.poll();
        }
        System.out.println("队列长度为："+linkQueue.size());
        System.out.println("队首元素为："+linkQueue.front());
    }
}
