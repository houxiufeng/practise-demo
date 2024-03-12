package com.example.demo.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //无返回值
//        CompletableFuture<Void> hi = CompletableFuture.runAsync(() -> getWord("hi"));
//        hi.get();
//        System.out.println("over");

        //有返回值
        CompletableFuture<String> hi1 = CompletableFuture.supplyAsync(() -> getWord("allen"));
//        String s = hi1.get();
        String s = hi1.whenComplete((u, t) -> {
            System.out.println("u->" + u);//正常执行结果:hi allen
            System.out.println("t->" + t);//错误信息
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "error";
        }).get();
        System.out.println("got it! the result is:" + s);
    }

    public static String getWord(String s) {
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("run the getword");
        int a = 10/0;
        return "hi " + s;
    }
}
