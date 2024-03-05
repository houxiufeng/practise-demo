package com.example.demo;

public class ThreadTask1 implements Runnable, Comparable<ThreadTask1> {
    private int priority;
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public ThreadTask1() {
    }
    public ThreadTask1(int priority) {
        this.priority = priority;
    }
    public int compareTo(ThreadTask o) {
        // TODO Auto-generated method stub
        return 0;
    }
    // 1:从小到大排序。 -1:从大到小排序。
    public int compareTo(ThreadTask1 o) {
        return this.priority > o.priority?1:-1;
    }
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("priority: " + this.priority + ", ThreadName: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
