package chap1;
/**
* 
* @className Demo1
* @author liuc
* @date 2020-04-02 22:25
* @since JDK 1.8
**/
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println(System.currentTimeMillis());
            Thread.sleep(1000);
        }
    }
}
