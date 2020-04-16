package chap1;
/**
* 
* @className Demo16
* @author liuc
* @date 2020-04-04 15:53
* @since JDK 1.8
**/
public class Demo16 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1？" + Thread.interrupted());
        System.out.println("是否停止2？" + Thread.interrupted());
    }
}

