package com.demo.queue;
/**
* 链式队列实现类
* @className LinkQueue
* @author liuc
* @date 2020-03-20 15:16
* @since JDK 1.8
**/
public class LinkedQueue<T> implements Queue<T> {
    /**
     * 队列最大长度
     */
    private int maxSize;
    /**
     * 保存该链队列的头节点
     */
    private Node front;
    /**
     * 保存该链队列的尾节点
     */
    private Node rear;
    /**
     * 保存该链队列中已包含的节点数
     */
    private int nItems;

    /**
     * 初始化队列，并指定队列长度
     * @param
     * @return
     * @throws
     * @date 2020/3/20 15:18
     * @author liuc
     **/
    public LinkedQueue(int maxSize) {
        this.maxSize = maxSize;
        //空链队列，front和rear都是null
        Node p = new Node();
        p.data = null;
        p.next = null;
        front = rear = p;
    }

    /**
     * 以指定数据元素来创建链队列，该链队列只有一个元素
     * @param element
     * @return
     * @throws
     * @date 2020/3/20 15:19
     * @author liuc
     **/
    public LinkedQueue(T element) {
        front = new Node(element, null);
        //只有一个节点，front、rear都指向该节点
        rear = front;
        nItems++;
    }

    /**
     * 清空队列
     * @return
     * @throws
     * @date 2020/3/19 22:39
     * @author liuc
     **/
    @Override
    public void clear() {
        //将front、rear两个节点赋为null
        front = null;
        rear = null;
        nItems = 0;
    }

    /**
     * 判断队列是否为空
     * @return boolean
     * @throws
     * @date 2020/3/19 22:38
     * @author liuc
     **/
    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否已满
     * @return boolean
     * @throws
     * @date 2020/3/19 22:38
     * @author liuc
     **/
    @Override
    public boolean isFull() {
        return nItems == maxSize;
    }

    /**
     * 判断队列大小
     * @return int
     * @throws
     * @date 2020/3/19 22:38
     * @author liuc
     **/
    @Override
    public int size() {
        return nItems;
    }

    /**
     * 插入元素到对列中
     * @param element
     * @return
     * @throws
     * @date 2020/3/19 22:37
     * @author liuc
     **/
    @Override
    public void push(T element) {
        //如果该链队列还是空链队列
        if (front == null) {
            front = new Node(element, null);
            //只有一个节点，front、rear都指向该节点
            rear = front;
        }if(isFull()){
            throw new RuntimeException("队列已满");
        } else {
            //创建新节点
            Node newNode = new Node(element, null);
            //让尾节点的next指向新增的节点
            rear.next = newNode;
            //以新节点作为新的尾节点
            rear = newNode;
        }
        nItems++;
    }

    /**
     * 出队
     * @param
     * @return
     * @throws
     * @date 2020/3/20 15:28
     * @author liuc
     **/
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            //指向队头的第一个节点
            Node p = this.front.next;
            T obj = (T) p.data;
            this.front.next = p.next;
            if (rear == p) {
                rear = front;
            }
            nItems--;
            return obj;
        }
    }

    /**
     * 删除队首元素
     * @return Object
     * @throws
     * @date 2020/3/19 22:35
     * @author liuc
     **/
    @Override
    public Object pop() {
        return null;
    }

    /**
     * 取队首元素并返回
     * @return Object
     * @throws
     * @date 2020/3/19 22:35
     * @author liuc
     **/
    @Override
    public Object front() {
        return rear.data;
    }

    /**
     * 显示队列所有数据
     * @return
     * @throws
     * @date 2020/3/19 22:34
     * @author liuc
     **/
    @Override
    public void ddisplay() {
        for (Node current = front.next; current != null; current = current.next) {
            System.out.println(current.data);
        }
    }

}
