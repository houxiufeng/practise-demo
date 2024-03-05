package com.example.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这一篇讲的比较好：https://www.cnblogs.com/sxkgeek/p/9401632.html
 * 按我的理解：ReentrantLock 更为灵活，功能更丰富，能够实现一些synchronized无法实现的场景。比如：lockInterruptibly
 * 公平锁和非公平锁区别
 * 只要资源被其他线程占用，该线程就会添加到sync queue中的尾部，而不会先尝试获取资源。这也是fair和Nonfair最大的区别；
 * Nonfair每一次都会尝试去获取资源，如果此时该资源恰好被释放，则会被当前线程获取，这就造成了不公平的现象，当获取不成功，再加入队列尾部。
 */
public class ReentrantLockTest {

    /**
     * 公平锁：为了解决线程的饥饿问题，即低优先级的线程永远得不到cpu的调度。公平锁可以保证线程按照时间的先后顺序执行，避免饥饿现象的产生。但公平锁的效率比较低，因为要实现顺序执行，需要维护一个有序队列。
     * 非公平锁：
     * 重入锁的设计目的是避免线程的死锁。
     * AQS -> Lock中用到了一个同步队列，全称 AbstractQueuedSynchronizer
     * CAS -> CAS 是一条 CPU 的原子指令, CAS 操作包含三个操作数 -- 内存位置、预期数值和新值。CAS 的实现逻辑是将内存位置处的数值与预期数值想比较，若相等，则将内存位置处的值替换为新值。若不相等，则不做任何操作。
     *
     */
    public static void main(String[] args) throws InterruptedException{
        //公平策略
        Lock lock = new ReentrantLock(true);
//        Lock lock = new ReentrantLock();

        MyThread t1 = new MyThread("t1", lock);
        MyThread t2 = new MyThread("t2", lock);
        MyThread t3 = new MyThread("t3", lock);
        MyThread t4 = new MyThread("t4", lock);
        MyThread t5 = new MyThread("t5", lock);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    /**
     * void lock() // 如果锁可用就获得锁，如果锁不可用就阻塞直到锁释放
     * void lockInterruptibly() // 和lock()方法相似, 但阻塞的线程可中断, 抛出java.lang.InterruptedException 异常, 与之相比synchronized就不行，无法中断。
     * boolean tryLock() // 非阻塞获取锁; 尝试获取锁，如果成功返回 true, 否则转生就走，不留恋。
     * boolean tryLock(long timeout, TimeUnit timeUnit) //与上面的区别是我只等你一段时间，过期不候。还是转生就走。
     * void unlock() // 释放锁
     */

    private static class MyThread extends Thread {
        private Lock lock;
        public MyThread(String name, Lock lock) {
            super(name);
            this.lock = lock;
        }

        public void run () {
            lock.lock();
            try {
                System.out.println(Thread.currentThread() + " running");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
