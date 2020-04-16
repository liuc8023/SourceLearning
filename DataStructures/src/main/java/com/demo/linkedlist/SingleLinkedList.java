package com.demo.linkedlist;

import java.util.Stack;

/**
 * 单向链表
 * @className SingleLinkList
 * @author liuc
 * @date 2020-04-13 16:14
 * @since JDK 1.8
 **/
public class SingleLinkedList {
    /**
     * 先初始化一个头节点，头节点不能动,也不存放数据
     */
    private static Node head = new Node(0, null,null);
    //返回头节点
    public static Node getHead() {
        return head;
    }
    /**
     * 向链表添加数据
     * 思路，当不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next 指向 新的节点
     * @param node 要添加的数据
     * @return
     * @throws
     * @date 2020/4/13 16:19
     * @author liuc
     **/
    public void add(Node node) {
        //初始化要加入的节点
        Node temp = head;
        //找到尾结点
        while (temp.next != null) {
            temp = temp.next;
        }
        //已经包括了head.next为空的情况了
        temp.next = node;
    }

    /**
     * 按照节点编号正序将节点插入链表
     * 如果这个节点的id已经存在，则添加失败，并给出提示
     * @param node
     * @return
     * @throws
     * @date 2020/4/15 15:38
     * @author liuc
     **/
    public void addByOrder(Node node) {
        //因为头节点不能动，我们这里依然通过一个临时变量来找到添加的位置
        //又因为是单向链表，所以temp是要位于添加位置的前一个节点，这样才插入合法
        Node temp = head;
        //标识添加的元素是否存在，默认为false
        boolean flag = false;
        while (temp.next != null) {
            //虽然是单向链表，但是依据当前节点是可以写出下面任何一个位置的节点的相关属性
            if (temp.next.id > node.id) {
                break;
            } else if (temp.next.id == node.id){
                //说明编号已存在
                flag = true;
                break;
            } else {
                //后移，遍历当前链表
                temp = temp.next;
            }
        }
        if (flag) {
            System.out.printf("少侠你已经学会武功秘籍"+node.id+"-"+node.data+"了\r\n");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 遍历链表
     * @param
     * @return
     * @throws
     * @date 2020/4/13 16:44
     * @author liuc
     **/
    public void display() {
        if (head.next == null) {
            System.out.println("链表为空！");
        }else {
            //临时节点，从head开始
            Node temp = head.next;
            //遍历的时候不需要头节点了，因为头节点不存在有效数据
            while (temp != null) {
                System.out.println(temp);
                //继续下一个
                temp = temp.next;
            }
        }
    }

    /**
     * 获取链表的长度
     * @param
     * @return int 链表长度
     * @throws
     * @date 2020/4/13 16:45
     * @author liuc
     **/
    public int length() {
        int length = 0;
        //临时节点从head节点开始
        Node temp = head.next;
        // 找到尾节点
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     *  链表的冒泡排序
     *  排序思路：
     *  逐个节点进行排序
     *  把当前节点和下个节点的值进行比较，根据结果处理
     *  主要是更换了节点的编号及数据域
     *  没有更换节点对象本身
     *
     * @param
     * @return
     */
    public void bubbleSort(){
        //判断链表是否需要排序
        if (head == null || head.next == null) {
            return ;
        }
        //保存入参头节点的引用
        Node temp = head;
        /**
         * 尾部节点，是循环截止节点
         */
        Node tail = null;
        int in = 0;
        /**
         * 外部遍历是遍历每个节点
         */
        while(head.next != tail) {
            /**
             * 内部遍历是把当前冒泡的节点进行逐个比较
             */
            while (head.next != tail) {
                //互换节点的编号及数据域
                if (head.id > head.next.id) {
                    in = head.id;
                    head.id = head.next.id;
                    head.next.id = in;
                    Object obj = head.data;
                    head.data = head.next.data;
                    head.next.data = obj;
                }
                //指针下移一位
                head = head.next;
            }
            /**
             * tail作为遍历截止节点
             * 内部循环结束一次则成功把一个数放到它合适的位置，下次遍历不需要再遍历到已经排好位置的这个数
             * tail既是作为已经最后一个排好序的节点的引用
             */
            tail = head;
            //指针重新回到链表头部
            head = temp;
        }
        return ;
    }

    /**
     * 修改节点的信息, 根据id编号来修改，即id编号不能改.
     * @param node
     * @return
     * @throws
     * @date 2020/4/16 13:23
     * @author liuc
     **/
    public void update(Node node) {
        //判断是否空
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点, 根据id编号
        //定义一个辅助变量
        Node temp = head.next;
        //表示是否找到该节点
        boolean flag = false;
        while(true) {
            if (temp == null) {
                //已经遍历完链表
                break;
            }
            if(temp.id == node.id) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if(flag) {
            temp.data = node.data;
        } else {
            //没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", node.id);
        }
    }

    /**
     * 删除节点
     * 思路
     * 1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * 2. 说明我们在比较时，是temp.next.id 和  需要删除的节点的id比较
     * @param id
     * @return
     * @throws
     * @date 2020/4/16 13:34
     * @author liuc
     **/
    public void delete(int id) {
        Node temp = head;
        // 标志是否找到待删除节点的
        boolean flag = false;
        while(true) {
            //已经到链表的最后
            if(temp.next == null) {
                break;
            }
            if(temp.next.id == id) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            //temp后移，遍历
            temp = temp.next;
        }
        //判断flag
        if(flag) {
            //找到
            //可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的 %d 节点不存在\n", id);
        }
    }

    /**
     * 将单链表反转
     * @param
     * @return 
     * @throws 
     * @date 2020/4/16 14:06 
     * @author liuc
     **/
    public void reverseList() {
        Node temp = head;
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(temp.next == null || temp.next.next == null) {
            return ;
        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        Node cur = temp.next;
        // 指向当前节点[cur]的下一个节点
        Node next = null;
        Node reverseHead = new Node(0, "", null);
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        while(cur != null) {
            //先暂时保存当前节点的下一个节点，因为后面需要使用
            next = cur.next;
            //将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            //将cur 连接到新的链表上
            reverseHead.next = cur;
            //让cur后移
            cur = next;
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        temp.next = reverseHead.next;
    }

    /**
     *
     * @param
     * @return
     * @throws
     * @date 2020/4/16 14:10
     * @author liuc
     **/
    public void reversePrint() {
        Node temp = head;
        if(temp.next == null) {
            //空链表，不能打印
            return;
        }
        //创建要给一个栈，将各个节点压入栈
        Stack<Node> stack = new Stack<Node>();
        Node cur = temp.next;
        //将链表的所有节点压入栈
        while(cur != null) {
            stack.push(cur);
            //cur后移，这样就可以压入下一个节点
            cur = cur.next;
        }
        //将栈中的节点进行打印,pop 出栈
        while (stack.size() > 0) {
            //stack的特点是先进后出
            System.out.println(stack.pop());
        }
    }

    /**
     * 查找单链表中的倒数第k个结点 【新浪面试题】
     * 思路
     * 1. 编写一个方法，接收head节点，同时接收一个index
     * 2. index 表示是倒数第index个节点
     * 3. 先把链表从头到尾遍历，得到链表的总的长度 length
     * 4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
     * 5. 如果找到了，则返回该节点，否则返回nulll
     * @param head
     * @param index
     * @return Node
     * @throws 
     * @date 2020/4/16 14:16 
     * @author liuc
     **/
    public Node findLastIndexNode(Node head, int index) {
        //判断如果链表为空，返回null
        if(head.next == null) {
            //没有找到
            return null;
        }
        //第一个遍历得到链表的长度(节点个数)
        int size = length();
        //第二次遍历  size-index 位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if(index <=0 || index > size) {
            return null;
        }
        //定义给辅助变量， for 循环定位到倒数的index
        //3 // 3 - 1 = 2
        Node cur = head.next;
        for(int i =0; i< size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 判断链表是否为空
     * @param
     * @return
     * @throws
     * @date 2020/4/16 14:24
     * @author liuc
     **/
    public boolean isEmpty(){
        return length() == 0;
    }
}
