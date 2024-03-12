package com.example.demo.juc;

public class Data {
    private Integer number = 0;


    public synchronized void increment() throws InterruptedException {

        if (number != 0) {
            this.wait();
        }
        this.number++;
        System.out.println(Thread.currentThread().getName() + "->" + this.number);
        this.notify();
    }

    public synchronized void decrement() throws InterruptedException {

        if (number == 0) {
            this.wait();
        }
        this.number--;
        System.out.println(Thread.currentThread().getName() + "->" + this.number);
        this.notify();
    }

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }, "B").start();
    }
}
