package com.example.demo.practice;

import java.util.concurrent.Semaphore;

public class PrintABC {
    private int times;
    private Semaphore semaphoreA =new Semaphore(1);
    private Semaphore semaphoreB =new Semaphore(0);
    private Semaphore semaphoreC =new Semaphore(0);

    public PrintABC(int times) {
        this.times=times;
    }


    public static void main(String[] args) {
        PrintABC PrintABC =new PrintABC(10);
        new Thread(PrintABC::printA).start();
        new Thread(PrintABC::printB).start();
        new Thread(PrintABC::printC).start();


    }
    public void printA() {
        print("A",semaphoreA,semaphoreB);
    }
    public void printB() {
        print("B",semaphoreB,semaphoreC);
    }
    public void printC() {
        print("C",semaphoreC,semaphoreA);
    }


    public void print(String name, Semaphore current, Semaphore next) {
        for(int i=0;i<times;i++) {
            try {
                current.acquire();
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(name);
            next.release();
        }

    }
}
