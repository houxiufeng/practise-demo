package com.example.demo.juc;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcutorTest {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor noticePool = new ThreadPoolExecutor(
                5,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new CustomizableThreadFactory("notice-pool"),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

//        System.out.println(noticePool.getCorePoolSize());
//
//        noticePool.submit(() -> {
//            System.out.println("hello");
//        });
//        TimeUnit.SECONDS.sleep(2);
//
//        System.out.println(noticePool.getCorePoolSize());
//
//        noticePool.submit(() -> {
//            System.out.println("world");
//        });
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println(noticePool.getCorePoolSize());

        noticePool.execute(() -> System.out.println("sfsfs"));



    }
}
