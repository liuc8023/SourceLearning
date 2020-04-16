package com.demo.linkedlist;
/**
 *
 * @className Node
 * @author liuc
 * @date 2020-04-13 14:46
 * @since JDK 1.8
 **/
public class Node {
    /**
     * 节点编号
     */
    public int id;
    /**
     * 数据域
     */
    public Object data;
    /**
     * 指针域，指向下一个节点
     */
    public Node next;

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(int id, Object data, Node next) {
        this.id = id;
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString(){
        return "Node{" +
                "id=" + id +
                ", data='" + data + '\''+
                '}';
    }
}
