package chap1;
/**
* 
* @className Demo15
* @author liuc
* @date 2020-04-04 15:47
* @since JDK 1.8
**/
public class Demo15 {
    public static void main(String[] args) {
        Thread t = new Demo15Thread();
        t.start();
        t.interrupt();
        System.out.println("是否停止1？" + t.isInterrupted());
        System.out.println("是否停止2？" + Thread.interrupted());
    }
}

class Demo15Thread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("i=" + i);
        }
    }
}
