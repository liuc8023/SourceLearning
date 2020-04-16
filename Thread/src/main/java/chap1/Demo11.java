package chap1;
/**
* 
* @className Demo11
* @author liuc
* @date 2020-04-04 12:46
* @since JDK 1.8
**/
public class Demo11 {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + ", " + t.getId());
    }
}
