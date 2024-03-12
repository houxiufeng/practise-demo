package com.example.demo.practice;


class TestThread implements Runnable{

    private static char[] ch = {'A', 'B', 'C'};

    private static int count = 0;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(;;)
            print();
    }

    private static synchronized void print() {
        System.out.println(Thread.currentThread().getName() + ch[count % 3]);

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count ++;
    }

}

class Solution {

    public static void main(String[] args) {
        new Thread(new TestThread()).start();
        new Thread(new TestThread()).start();
        new Thread(new TestThread()).start();

    }

}
