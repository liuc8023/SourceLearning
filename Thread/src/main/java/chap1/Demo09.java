package chap1;
/**
* 
* @className Demo09
* @author liuc
* @date 2020-04-04 11:54
* @since JDK 1.8
**/
public class Demo09 {
    public static void main(String[] args) {
        Thread t = new Demo09Thread();
        System.out.println("准备开始启动线程：" + t.isAlive());
        // 启动线程
        t.start();
        System.out.println("启动线程后：" + t.isAlive());
    }
}

class Demo09Thread extends Thread{
    public Demo09Thread(){
        System.out.println("构造方法开始");
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(this.isAlive());
        System.out.println("构造方法结束");
    }

    @Override
    public void run() {
        System.out.println("run方法开始");
        System.out.println(Thread.currentThread().isAlive());
        System.out.println("run方法运行状态：" + this.isAlive());
        System.out.println("run方法结束");
    }
}
