package chap1;
/**
* 
* @className Demo02
* @author liuc
* @date 2020-04-02 22:38
* @since JDK 1.8
**/
public class Demo02 {
    public static void main(String[] args) {
        Thread t = new Demo02Thread();
        //启动线程
        t.start();
        System.out.println("运行了main方法");
    }
}

class Demo02Thread extends Thread {
    @Override
    public void run() {
        System.out.println("运行了run方法");
    }
}
