package chap1;
/**
* 
* @className Demo10
* @author liuc
* @date 2020-04-04 12:43
* @since JDK 1.8
**/
public class Demo10 {
    public static void main(String[] args) {
        Thread t = new Demo10Thread();
        System.out.println("开始于" + System.currentTimeMillis());
        t.start();
        System.out.println("结束于" + System.currentTimeMillis());
    }
}

class Demo10Thread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("线程开始于" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("线程结束于" + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
