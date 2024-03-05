package com.example.demo;

import java.util.concurrent.*;

/**
 * 拒绝策略：
 * AbortPolicy：该当最大线程数量上限 && 缓冲队列满了，后续再有任务提交过来就抛异常给主线程。
 * CallerRunsPolicy：当最大线程数量上限 && 缓冲队列满了，后续再有任务提交过来就让当前主线程去处理这个任务。
 * DiscardOldestPolicy：最大线程数量上限 && 缓冲队列满了，后续再有任务提交过来，会将缓冲队列队首的任务移除，然后在队末加入新任务
 * DiscardPolicy: 当最大线程数量上限 && 缓冲队列满了，后续再有任务提交过来就将此任务直接丢弃
 */
public class ThreadPool {
    private static ExecutorService pool;
    public static void main(String[] args) {
//        testSynchronousQueue();
//        testArrayBlockingQueue();
//        testLinkedBlockingQueue();
        tesPriorityBlockingQueue();
    }

    /**
     * 提交队列：SynchronousQueue队列，SynchronousQueue是一个特殊的BlockingQueue，它没有容量
     * corePoolSize -->[] --> maximumPoolSize, 所以任务数量在 corePoolSize 到 maximumPoolSize 之间 可以正常执行。
     * 可以看到，当任务队列为SynchronousQueue，创建的线程数大于maximumPoolSize时，直接执行了拒绝策略抛出异常
     * 执行结果：
     * pool-1-thread-1
     * pool-1-thread-2
     * Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task com.example.demo.ThreadTask@380fb434 rejected from java.util.concurrent.ThreadPoolExecutor@668bc3d5[Running, pool size = 2, active threads = 2, queued tasks = 0, completed tasks = 0]
     * 	at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2055)
     * 	at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:825)
     * 	at java.base/java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1355)
     * 	at com.example.demo.ThreadPool.main(ThreadPool.java:10)
     *
     */
    public static void testSynchronousQueue() {
        pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 3; i++) {
            pool.execute(new ThreadTask());
        }
    }

    /**
     * 有界的任务队列: 白话翻译为，10个任务以内就不劳烦maximumPoolSize 来创建新线程了，我corePoolSize有能力处理完。
     * 执行结果：
     * pool-1-thread-1
     * pool-1-thread-1
     * pool-1-thread-1
     */
    public static void testArrayBlockingQueue() {
        pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10),Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 3; i++) {
            pool.execute(new ThreadTask());
        }
    }

    /**
     * 使用无界任务队列，线程池的任务队列可以无限制的添加新的任务，而线程池创建的最大数量就是你corePoolSize设置的数量，
     * 也就是说在这种情况下maximumPoolSize这个参数是无效的
     * 执行结果:
     * pool-1-thread-1
     * pool-1-thread-1
     * pool-1-thread-1
     */
    public static void testLinkedBlockingQueue() {
        pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(),Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 3; i++) {
            pool.execute(new ThreadTask());
        }
        pool.shutdown();
    }

    /**
     * 优先任务队列: PriorityBlockingQueue它其实是一个特殊的无界队列，所以maximumPoolSize是无效的.
     * PriorityBlockingQueue队列可以自定义规则根据任务的优先级顺序先后执行
     * 执行结果：
     * priority: 0, ThreadName: pool-1-thread-1
     * priority: 1, ThreadName: pool-1-thread-1
     * priority: 2, ThreadName: pool-1-thread-1
     * priority: 3, ThreadName: pool-1-thread-1
     * priority: 4, ThreadName: pool-1-thread-1
     */

    public static void tesPriorityBlockingQueue() {
        pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(),Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 5; i++) {
            pool.execute(new ThreadTask1(i));
        }
        pool.shutdown();
    }
}

