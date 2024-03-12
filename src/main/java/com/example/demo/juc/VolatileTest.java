package com.example.demo.juc;

import java.util.concurrent.TimeUnit;

public class VolatileTest {

    private volatile static int num = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            while (num == 0) {

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        num = 1;
        System.out.println(num);

    }
}
