package chap1;
/**
* 
* @className Demo08
* @author liuc
* @date 2020-04-04 11:54
* @since JDK 1.8
**/
public class Demo08 {
    public static void main(String[] args) {
        Thread t = new Demo08Thread();
        t.start();
        // System.out.println("main方法：" + Thread.currentThread().getName());
    }
}

class Demo08Thread extends Thread{
    public Demo08Thread(){
        System.out.println("构造方法开始");
        System.out.println("构造方法：" + Thread.currentThread().getName());
        System.out.println(this.getName());
        System.out.println("构造方法结束");
    }

    @Override
    public void run() {
        System.out.println("run方法开始");
        System.out.println("run方法" + Thread.currentThread().getName());
        System.out.println(this.getName());
        System.out.println("run方法结束");
    }
}