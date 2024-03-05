package com.example.demo;

public class ThreadTask implements Runnable {
    public ThreadTask() {}
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    }
}
