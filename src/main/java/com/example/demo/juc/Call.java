package com.example.demo.juc;

import java.util.concurrent.FutureTask;

public class Call {
    public static void main(String[] args) {
        new Thread(new FutureTask<>(null)).start();
    }
}
