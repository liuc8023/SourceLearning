package com.demo.queue;
/**
* 单向队列实现类
* @className ArrayQueue
* @author liuc
* @date 2020-03-19 21:55
* @since JDK 1.8
**/
public class ArrayQueue<T> implements Queue<T>{
    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 该数据用于存放数据, 模拟队列
     */
    private T[] arr;

    /**
     * 创建队列的构造器
     * @param
     * @return boolean
     * @throws
     * @date 2020/3/20 14:28
     * @author liuc
     **/
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = (T[])new Object[maxSize];
        //队列头部
        front = 0;
        //队列尾，指向队列尾的数据(即就是队列最后一个数据)
        rear = 0;
    }

    /**
     * 清空队列
     * @param
     * @return boolean
     * @throws
     * @date 2020/3/20 14:28
     * @author liuc
     **/
    @Override
    public void clear() {
        front = rear = 0;
    }

    /**
     * 判断队列是否为空
     * @param
     * @return boolean
     * @throws
     * @date 2020/3/20 14:28
     * @author liuc
     **/
    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 判断队列是否已满
     * @param
     * @return boolean
     * @throws
     * @date 2020/3/20 14:28
     * @author liuc
     **/
    @Override
    public boolean isFull() {
        return rear == maxSize;
    }

    /**
     * 判断队列大小
     * @param
     * @return int
     * @throws
     * @date 2020/3/20 14:28
     * @author liuc
     **/
    @Override
    public int size() {
        return rear - front;
    }

    /**
     * 插入元素到对列中
     * @param t
     * @return
     * @throws RuntimeException
     * @date 2020/3/20 14:28
     * @author liuc
     **/
    @Override
    public void push(T t) {
        // 判断队列是否满
        if (isFull()) {
            throw new RuntimeException("队列满，不能加入数据!");
        }
        arr[rear] = t;
        // 让rear 后移
        rear++;
    }

    /**
     * 删除队首元素
     * @return T
     * @throws RuntimeException
     * @date 2020/3/20 14:28
     * @author liuc
     **/
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        T t = arr[front];
        arr[front] = null;
        front = (front + 1) % (arr.length);
        maxSize--;
        return t;
    }

    /**
     * 取队首元素并返回
     * @return T
     * @throws RuntimeException
     * @date 2020/3/20 14:28
     * @author liuc
     **/
    @Override
    public T front() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        return arr[front];
    }

    /**
     * 显示队列所有数据
     * @return
     * @throws
     * @date 2020/3/20 14:28
     * @author liuc
     **/
    @Override
    public void display() {
        int i = front;
        while (i < rear) {
            System.out.println(arr[i]);
            i++;
        }
    }

}
