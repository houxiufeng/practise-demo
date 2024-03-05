package com.example.demo;

import org.junit.jupiter.api.Test;

/**
 * 死锁要点：
 * 1. 必须是2个不同的线程，因为一个线程中synchronized具有重入性，它能进去。
 * 2. 必须互相持有对方想要的锁。
 * 冷知识：
 * 用main方法测试不需要在最后线程等待Thread.sleep(Long.MAX_VALUE);
 * 用test方式需要线程等待Thread.sleep(Long.MAX_VALUE); 猜测是因为test方式是启动了一个子线程。而main方法是主线程本身.
 */
public class DeadLockTest {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    /**
     * main方式测试
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> m1()).start();
        new Thread(() -> m2()).start();
    }

    /**
     * test方式测试
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        new Thread(() -> m1()).start();
        new Thread(() -> m2()).start();
        System.out.println("hello");
        Thread.sleep(Long.MAX_VALUE);
    }


    private static void m1(){
        System.out.println("m1 process");
        synchronized (lock1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2) {
                System.out.println("m1 done");
            }
        }
    }

    private static void m2() {
        System.out.println("m2 process");
        synchronized (lock2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock1) {
                System.out.println("m2 done");
            }
        }
    }
}
