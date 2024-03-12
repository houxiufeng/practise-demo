package com.example.demo.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 举例子：收集龙珠
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, ()->{
            System.out.println("集齐7颗龙珠，召唤神龙!");
        });

        for (int i = 0; i < 7; i++) {
            final int temp = i + 1;
            new Thread(() -> {
                System.out.println("get ball of " + temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
