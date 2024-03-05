package com.example.demo.practice;

/**
 * join()的使用场景
 * 在很多情况下，主线程创建并启动子线程，如果子线程中要进行大量的耗时运算，主线程将可能早于子线程结束。
 * 如果主线程需要知道子线程的执行结果时，就需要等待子线程执行结束了。主线程可以sleep(xx),但这样的xx时间不好确定，因为子线程的执行时间不确定，join()方法比较合适这个场景。
 *
 * 解释一下，是主线程等待子线程的终止。也就是说主线程的代码块中，如果碰到了t.join()方法，此时主线程需要等待(阻塞)，等待子线程结束了(Waits for this thread to die.),才能继续执行t.join()之后的代码块。
 */
public class Racer implements Runnable{
    private String name;

    public Racer(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(this.name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Racer("t1"));
        Thread t2 = new Thread(new Racer("t2"));
        Thread t3 = new Thread(new Racer("t3"));
        Thread t4 = new Thread(new Racer("t4"));
        Thread t5 = new Thread(new Racer("t5"));
        t5.start();
        t3.start();
        t1.start();
        t3.join();
        System.out.println("=========================");
        t2.start();
        t1.join();
        t4.start();
        t2.join();
        t4.join();
        t5.join();
    }
}
