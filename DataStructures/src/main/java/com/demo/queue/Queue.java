package com.demo.queue;
/**
* 队列接口
* @className Queue
* @author liuc
* @date 2020-03-19 21:41
* @since JDK 1.8
**/
public interface Queue<T> {

    /**
     * 清空队列
     * @param
     * @return
     * @throws
     * @date 2020/3/19 22:39
     * @author liuc
     **/
    public void clear();

    /**
     * 判断队列是否为空
     * @param
     * @return boolean
     * @throws
     * @date 2020/3/19 22:38
     * @author liuc
     **/
    public boolean isEmpty();

    /**
     * 判断队列是否已满
     * @param
     * @return boolean
     * @throws
     * @date 2020/3/19 22:38
     * @author liuc
     **/
    public boolean isFull();

    /**
     * 判断队列大小
     * @param
     * @return int
     * @throws
     * @date 2020/3/19 22:38
     * @author liuc
     **/
    public int size();

    /**
     * 插入元素到对列中
     * @param x
     * @return
     * @throws
     * @date 2020/3/19 22:37
     * @author liuc
     **/
    public void push(T x);

    /**
     * 删除队首元素
     * @param
     * @return Object
     * @throws
     * @date 2020/3/19 22:35
     * @author liuc
     **/
    public Object pop();

    /**
     * 取队首元素并返回
     * @param
     * @return Object
     * @throws
     * @date 2020/3/19 22:35
     * @author liuc
     **/
    public Object front();

    /**
     * 显示队列所有数据
     * @param
     * @return
     * @throws
     * @date 2020/3/19 22:34
     * @author liuc
     **/
    public void display();

}
