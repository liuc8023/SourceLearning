package com.thread.api;

/**
 * @author liuc
 * @className UserDemo
 * @description
 * @date 2020/7/9 17:07
 * @since JDK 1.8
 */
public class UserDemo {
    public static void main(String[] args) {
        try {
            User user = new User();
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    super.run();
                    user.updateUserNameAndPassWord("b", "bb");
                }
            };
            t1.setName("A");
            t1.start();
            Thread.sleep(100);
            Thread t2 = new Thread() {
                @Override
                public void run() {
                    super.run();
                    user.printUserNameAndPassWord();
                }
            };
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class User {
        private String userName = "a";
        private String passWord = "aa";

        public void updateUserNameAndPassWord(String userName, String passWord) {
            this.userName = userName;
            if ("A".equals(Thread.currentThread().getName())) {
                System.out.println("停止A线程");
                Thread.currentThread().suspend();
            }
            this.passWord = passWord;
        }

        public void printUserNameAndPassWord() {
            System.out.println("userName=" + userName + ",passWord=" + passWord);
        }
    }
}
