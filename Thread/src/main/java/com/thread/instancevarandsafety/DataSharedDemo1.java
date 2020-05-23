package com.thread.instancevarandsafety;

/**
 * @author liuc
 * @className DataSharedDemo1
 * @description 多线程成员变量共享
 * @date 2020/5/8 15:22
 * @since JDK 1.8
 */
public class DataSharedDemo1 extends Thread{
    private static int count=5;
    public DataSharedDemo1(String name) {
        super(name);
        //设置线程名称
        this.setName(name);
    }
    @Override
    public void run() {
        //此处不要用for循环，否则将是一个线程循环完，其他线程没有机会运行
        super.run();
        count--;
        System.out.println("由线程："+this.getName()+" 计算，count= "+count);
    }
}
