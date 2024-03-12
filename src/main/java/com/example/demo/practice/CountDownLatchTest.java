package com.example.demo.practice;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(1);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println(2);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(3);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            countDownLatch.await();
            System.out.println("over");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
