package com.demo.queue;
/**
* Node实例代表链队列的节点
* @className Node
* @author liuc
* @date 2020-03-20 15:14
* @since JDK 1.8
**/
public class Node<T> {
    /**
     * 保存节点的数据
     */
    public T data;
    /**
     * 指向下个节点的引用
     */
    public Node next;
    /**
     * 无参数的构造器
     * @param
     * @return
     * @throws
     * @date 2020/3/20 15:15
     * @author liuc
     **/
    public Node() {
    }

    /**
     * 初始化全部属性的构造器
     * @param data 保存节点的数据
     * @param next 指向下个节点的引用
     * @return
     * @throws
     * @date 2020/3/20 15:15
     * @author liuc
     **/
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}
