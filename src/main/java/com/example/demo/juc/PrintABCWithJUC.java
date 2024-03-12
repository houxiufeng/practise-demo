package com.example.demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABCWithJUC {

    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        }, "C").start();
    }




    public static class Data3 {
        private Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
//        Condition condition2 = lock.newCondition();
//        Condition condition3 = lock.newCondition();
        private int numbers = 1;

        public void printA() {
            lock.lock();
            try {
                while (numbers != 1) {
                    condition1.await();
                }
                System.out.println(Thread.currentThread().getName() + "->A");
                numbers = 2;
//                condition2.signal();
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void printB() {
            lock.lock();
            try {
                while (numbers != 2) {
//                    condition2.await();
                    condition1.await();
                }
                System.out.println(Thread.currentThread().getName() + "->B");
                numbers = 3;
//                condition3.signal();
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void printC() {
            lock.lock();
            try {
                while (numbers != 3) {
//                    condition3.await();
                    condition1.await();
                }
                System.out.println(Thread.currentThread().getName() + "->C");
                numbers = 1;
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
