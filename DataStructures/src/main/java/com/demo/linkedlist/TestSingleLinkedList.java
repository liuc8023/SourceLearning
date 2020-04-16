package com.demo.linkedlist;
/**
 * 测试单向链表
 * @className TestSingleLinkedList
 * @author liuc
 * @date 2020-04-13 16:31
 * @since JDK 1.8
 **/
public class TestSingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        System.out.println(linkedList.isEmpty());
        Node node1 = new Node(1,"降龙十八掌",null);
        Node node2 = new Node(2,"九阳真经",null);
        Node node3 = new Node(3,"九阴真经",null);
        Node node4 = new Node(4,"乾坤大挪移",null);
        Node node5 = new Node(5,"独孤九剑",null);
        Node node6 = new Node(6,"葵花宝典",null);
        linkedList.display();
//        linkedList.addByOrder(node6);
//        linkedList.addByOrder(node6);
//        linkedList.addByOrder(node5);
//        linkedList.addByOrder(node1);
//        linkedList.addByOrder(node2);
//        linkedList.addByOrder(node4);
//        linkedList.addByOrder(node3);
        linkedList.add(node6);
        linkedList.add(node5);
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node4);
        linkedList.add(node3);
        System.out.println(linkedList.isEmpty());
        linkedList.bubbleSort();
        System.out.println("天下武功排行榜：");
        linkedList.display();
        System.out.println("藏经阁武功秘籍数量："+linkedList.length());
        //测试一下看看是否得到了倒数第K个节点
        Node res = linkedList.findLastIndexNode(SingleLinkedList.getHead(), 4);
        System.out.println("res=" + res);
        Node node7 = new Node(7,"辟邪剑谱",null);
        linkedList.update(node7);
        linkedList.display();
        System.out.println("更新藏经阁武功秘籍~~~~");
        Node node8 = new Node(6,"辟邪剑谱",null);
        linkedList.update(node8);
        linkedList.display();
        System.out.println("废弃藏经阁武功秘籍~~~~");
        linkedList.delete(5);
        linkedList.display();
        System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
        linkedList.reversePrint();
        System.out.println("倒序武功秘籍排行榜~~~~");
        linkedList.reverseList();
        linkedList.display();

    }
}
