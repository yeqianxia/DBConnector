package com.qianxia.experiment.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author qianxia
 * @date 2021/12/20  14:33
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("test");
        new Thread(() -> System.out.println(threadLocal.get())).start();

        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set("test1");
        new Thread(() -> System.out.println(inheritableThreadLocal.get())).start();

        TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();
        transmittableThreadLocal.set("test2");
        new Thread(() -> System.out.println(transmittableThreadLocal.get())).start();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4, 8, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(() -> System.out.println(transmittableThreadLocal.get()));
        }
        threadPoolExecutor.shutdown();
    }

}
