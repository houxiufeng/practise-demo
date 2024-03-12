package com.example.demo.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCache.putWithLock(tmp+"", tmp+"");
            }, String.valueOf(i)).start();

        }

        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCache.getWithLock(tmp+"");
            }, String.valueOf(i)).start();
        }

    }

}

class MyCache {
    private volatile Map<String, String> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void putWithLock(String key, String value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完毕" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String getWithLock(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            String s = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完毕" + key);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return "invalid";
    }

    public void put(String key, String value) {
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完毕" + key);
    }

    public String get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        String s = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完毕" + key);
        return s;
    }

}
