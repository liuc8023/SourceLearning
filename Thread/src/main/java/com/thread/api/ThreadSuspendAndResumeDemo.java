package com.thread.api;

/**
 * @author liuc
 * @className ThreadSuspendAndResumeDemo
 * @description 测试suspend()和resume()方法
 * @date 2020/7/8 17:22
 * @since JDK 1.8
 */
public class ThreadSuspendAndResumeDemo {
    public static void main(String[] args) {
        try {
            ThreadSuspendAndResume tsr = new ThreadSuspendAndResume();
            Thread thread = new Thread(tsr);
            // 启动线程
            thread.start();
            Thread.sleep(5000);
            // 暂停线程
            thread.suspend();
            System.out.println("A=" + System.currentTimeMillis() + " i=" + tsr.getI());
            Thread.sleep(5000);
            System.out.println("A=" + System.currentTimeMillis() + " i=" + tsr.getI());
            // 恢复暂停的线程
            thread.resume();
            Thread.sleep(5000);
            // 暂停线程
            thread.suspend();
            System.out.println("B=" + System.currentTimeMillis() + " i=" + tsr.getI());
            Thread.sleep(5000);
            System.out.println("B=" + System.currentTimeMillis() + " i=" + tsr.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class ThreadSuspendAndResume implements Runnable {
        private long i = 0;

        public long getI() {
            return i;
        }

        public void setI(long i) {
            this.i = i;
        }

        @Override
        public void run() {
            while (true) {
                i++;
            }
        }
    }
}
