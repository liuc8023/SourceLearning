package chap1;
/**
* 
* @className Demo17
* @author liuc
* @date 2020-04-04 15:55
* @since JDK 1.8
**/
public class Demo17 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Demo17Thread();
        t.start();
        Thread.sleep(1);
        t.interrupt();
    }
}

class Demo17Thread extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("已经是停止状态了！我要退出");
//                break;
                    throw new InterruptedException();
                }
                System.out.println("i=" + i);
            }
            System.out.println("这里是结束循环后的代码");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
