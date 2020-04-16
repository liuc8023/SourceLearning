package chap1;
/**
 *
 * @className Demo05
 * @author liuc
 * @date 2020-04-02 22:42
 * @since JDK 1.8
 **/
public class Demo05 {
    public static void main(String[] args) {
        Runnable r = new Demo05Thread();
        Thread t = new Thread(r);
        t.start();
        System.out.println("运行了main方法");
    }
}

class Demo05Thread implements Runnable{
    @Override
    public void run() {
        System.out.println("运行了run方法");
    }
}